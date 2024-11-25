package com.throrun.messenger.user;

import com.throrun.messenger.security.AuthenticationService;
import com.throrun.messenger.user.req_res.SignInReq;
import com.throrun.messenger.user.req_res.SignInRes;
import com.throrun.messenger.user.req_res.SignUpReq;
import com.throrun.messenger.user.req_res.SignUpRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ProfileController.REQUEST_MAPPING)
@RequiredArgsConstructor
public class ProfileController implements ProfileApi {

    public static final String REQUEST_MAPPING = "api/messenger/user";
    private final AuthenticationService authenticationService;

    @Override
    public SignUpRes createUser(SignUpReq signUpReq) {
        return authenticationService.signUp(signUpReq);
    }

    @Override
    public SignInRes login(SignInReq signInReq) {
        return authenticationService.signIn(signInReq);
    }

    @Override
    public String ping() {
        return "pong";
    }
}
