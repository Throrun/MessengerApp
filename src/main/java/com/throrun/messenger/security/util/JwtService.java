package com.throrun.messenger.security.util;

import com.throrun.messenger.user.data.model.Profile;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUserName(String token);

    String generateToken(Profile profile);

    boolean isTokenValid(String jwt, UserDetails userDetails);
}
