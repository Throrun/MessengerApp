package com.throrun.messenger.security;

import com.throrun.messenger.user.req_res.SignInReq;
import com.throrun.messenger.user.req_res.SignInRes;
import com.throrun.messenger.user.req_res.SignUpReq;
import com.throrun.messenger.user.req_res.SignUpRes;

public interface AuthenticationService {
    SignUpRes signUp(SignUpReq signUpReq);

    SignInRes signIn(SignInReq signInReq);
}
