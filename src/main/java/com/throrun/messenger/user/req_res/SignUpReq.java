package com.throrun.messenger.user.req_res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpReq {
    private String name;
    private String email;
    private String password;
}
