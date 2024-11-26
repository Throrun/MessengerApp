package com.throrun.messenger.user;

import com.throrun.messenger.user.req_res.GetProfilesRes;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ProfileService {
    UserDetailsService userDetailsService();

    void registerNewUser(String name, String email);

    GetProfilesRes getProfiles();
}
