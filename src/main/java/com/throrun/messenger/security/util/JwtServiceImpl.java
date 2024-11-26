package com.throrun.messenger.security.util;

import com.throrun.messenger.user.data.model.Profile;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtServiceImpl implements JwtService {
    private static final long JWT_TOKEN_VALIDITY = 15 * 60;

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public String extractUserName(String token) {
        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }

    @Override
    public String generateToken(Profile profile) {
        return Jwts.builder()
                .subject(profile.getName())
                .issuedAt(new Date(System.currentTimeMillis() * 1000))
                .expiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();

    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        Date expiration = Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload().getExpiration();
        return expiration.after(new Date());
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
