package com.throrun.messenger.user;

import com.throrun.messenger.common.type.MessengerResponse;
import com.throrun.messenger.user.req_res.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProfileApi {
    @PostMapping("/register")
    ResponseEntity<MessengerResponse<SignUpRes>> createUser(@RequestBody SignUpReq signUpReq);

    @PostMapping("/login")
    ResponseEntity<MessengerResponse<SignInRes>> login(@RequestBody SignInReq signInReq);

    @GetMapping("/profiles")
    ResponseEntity<MessengerResponse<GetProfilesRes>> getProfiles();

    @GetMapping("/ping")
    ResponseEntity<MessengerResponse<String>> ping();

}
