package com.throrun.messenger.security;

import com.throrun.messenger.security.util.JwtService;
import com.throrun.messenger.user.data.model.Profile;
import com.throrun.messenger.user.data.repsitory.ProfileRepository;
import com.throrun.messenger.user.req_res.SignInReq;
import com.throrun.messenger.user.req_res.SignInRes;
import com.throrun.messenger.user.req_res.SignUpReq;
import com.throrun.messenger.user.req_res.SignUpRes;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    public final ProfileRepository profileRepository;
    public final PasswordEncoder passwordEncoder;
    public final JwtService jwtService;
    public final AuthenticationManager authenticationManager;

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
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInReq.getLogin(), signInReq.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException("Wrong email or password");
        }
        Optional<Profile> OptProfile = profileRepository.findByName(signInReq.getLogin());
        Profile profile = OptProfile.orElseGet(() -> profileRepository.findByEmail(signInReq.getLogin()).orElseThrow());
        return SignInRes.builder().token(jwtService.generateToken(profile)).build();

    }
}
