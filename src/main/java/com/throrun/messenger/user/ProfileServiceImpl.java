package com.throrun.messenger.user;

import com.throrun.messenger.user.data.model.Profile;
import com.throrun.messenger.user.data.repsitory.ProfileRepository;
import com.throrun.messenger.user.req_res.GetProfilesRes;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
                Optional<Profile> profile = profileRepository.findByName(login);
                return profile.orElseGet(() -> profileRepository.findByEmail(login).orElseThrow());
            }
        };
    }

    public void registerNewUser(String name, String email) {
        profileRepository.save(Profile.builder().id(UUID.randomUUID()).email(email).name(name).build());
    }

    @Override
    public GetProfilesRes getProfiles() {
        List<Profile> profiles = profileRepository.findAll();
        return GetProfilesRes.builder().profiles(profiles).build();
    }
}
