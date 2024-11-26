package com.throrun.messenger.user;

import com.throrun.messenger.common.type.MessengerResponse;
import com.throrun.messenger.security.AuthenticationService;
import com.throrun.messenger.user.req_res.SignInReq;
import com.throrun.messenger.user.req_res.SignInRes;
import com.throrun.messenger.user.req_res.SignUpReq;
import com.throrun.messenger.user.req_res.SignUpRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ProfileController.REQUEST_MAPPING)
@RequiredArgsConstructor
public class ProfileController implements ProfileApi {

    public static final String REQUEST_MAPPING = "api/messenger/user";
    private final AuthenticationService authenticationService;

    @Override
    public ResponseEntity<MessengerResponse<SignUpRes>> createUser(SignUpReq signUpReq) {
        SignUpRes signUpRes = authenticationService.signUp(signUpReq);
        return ResponseEntity.status(201)
                .body(MessengerResponse.<SignUpRes>builder()
                        .message("user created!")
                        .data(signUpRes).build());
    }

    @Override
    public ResponseEntity<MessengerResponse<SignInRes>> login(SignInReq signInReq) {
        SignInRes signInRes = authenticationService.signIn(signInReq);
        return ResponseEntity.status(200)
                .body(MessengerResponse.<SignInRes>builder()
                        .message("login successfully!")
                        .data(signInRes).build());
    }

    @Override
    public ResponseEntity<MessengerResponse<String>> ping() {
        return ResponseEntity.status(200)
                .body(MessengerResponse.<String>builder()
                        .message("Success")
                        .data("pong")
                        .build());
    }
}
