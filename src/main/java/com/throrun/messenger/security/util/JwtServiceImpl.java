package com.throrun.messenger.security.util;

import com.throrun.messenger.user.data.model.Profile;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtServiceImpl implements JwtService {
    private static final long JWT_TOKEN_VALIDITY = 15 * 60;

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public String generateToken(Profile profile) {
        return Jwts.builder()
                .subject(profile.getName())
                .issuedAt(new Date(System.currentTimeMillis() * 1000))
                .expiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes())).compact();

    }
}
