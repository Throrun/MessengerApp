package com.throrun.messenger.user;

import com.throrun.messenger.chat.req_res.GetChatsRes;
import com.throrun.messenger.common.type.MessengerResponse;
import com.throrun.messenger.user.req_res.SignInReq;
import com.throrun.messenger.user.req_res.SignInRes;
import com.throrun.messenger.user.req_res.SignUpReq;
import com.throrun.messenger.user.req_res.SignUpRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProfileApi {
    @PostMapping("/register")
    ResponseEntity<MessengerResponse<SignUpRes>>  createUser(@RequestBody SignUpReq signUpReq);

    @PostMapping("/login")
    ResponseEntity<MessengerResponse<SignInRes>> login(@RequestBody SignInReq signInReq);

    @GetMapping("/ping")
    ResponseEntity<MessengerResponse<String>> ping();
}
