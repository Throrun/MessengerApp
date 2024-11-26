package com.throrun.messenger.user;

import com.throrun.messenger.user.data.model.Profile;
import com.throrun.messenger.user.data.repsitory.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
                Optional<Profile> profile = userRepository.findByName(login);
                return profile.orElseGet(() -> userRepository.findByEmail(login).orElseThrow());
            }
        };
    }

    public void registerNewUser(String name, String email) {
        userRepository.save(Profile.builder().id(UUID.randomUUID()).email(email).name(name).build());
    }
}
