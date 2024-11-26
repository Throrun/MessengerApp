package com.throrun.messenger.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ProfileService {
    UserDetailsService userDetailsService();
    void registerNewUser(String name, String email);
}
