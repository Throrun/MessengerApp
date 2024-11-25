package com.throrun.messenger.security;

import com.throrun.messenger.security.util.JwtService;
import com.throrun.messenger.user.data.model.Profile;
import com.throrun.messenger.user.data.repsitory.ProfileRepository;
import com.throrun.messenger.user.req_res.SignInReq;
import com.throrun.messenger.user.req_res.SignInRes;
import com.throrun.messenger.user.req_res.SignUpReq;
import com.throrun.messenger.user.req_res.SignUpRes;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    public final ProfileRepository profileRepository;
    public final PasswordEncoder passwordEncoder;
    public final JwtService jwtService;

    @Override
    public SignUpRes signUp(SignUpReq request) {
        if (profileRepository.findByNameOrEmail(request.getName(), request.getEmail()).isPresent()) {
            throw new RuntimeException("User exist");
        }
        Profile profile = Profile.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        profileRepository.save(profile);


        return SignUpRes.builder().token(jwtService.generateToken(profile)).build();
    }

    @Override
    public SignInRes signIn(SignInReq signInReq) {
        Optional<Profile> OptProfile = profileRepository.findByEmail(signInReq.getEmail());
        Profile profile = OptProfile.orElseThrow(() -> new RuntimeException("Wrong credentials"));
        if (passwordEncoder.matches(signInReq.getPassword(),profile.getPassword())){
            return SignInRes.builder().token(jwtService.generateToken(profile)).build();
        } else {
            throw new RuntimeException(("Wrong credentials"));
        }
    }
}
