package com.throrun.messenger.security.util;

import com.throrun.messenger.user.data.model.Profile;

public interface JwtService {
    String generateToken(Profile profile);
}
