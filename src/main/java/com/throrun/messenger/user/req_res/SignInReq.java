package com.throrun.messenger.user.req_res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInReq {
    private String email;
    private String password;
}
