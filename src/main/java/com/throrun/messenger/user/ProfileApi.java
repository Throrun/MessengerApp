package com.throrun.messenger.user;

import com.throrun.messenger.user.req_res.SignInReq;
import com.throrun.messenger.user.req_res.SignInRes;
import com.throrun.messenger.user.req_res.SignUpReq;
import com.throrun.messenger.user.req_res.SignUpRes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProfileApi {
    @PostMapping("/register")
    SignUpRes createUser(@RequestBody SignUpReq signUpReq);

    @PostMapping("/login")
    SignInRes login(@RequestBody SignInReq signInReq);

    @GetMapping("/ping")
    String ping();
}
