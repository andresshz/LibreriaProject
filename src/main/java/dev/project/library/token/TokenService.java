package dev.project.library.token;

import java.time.Instant;
import java.util.Date;


import javax.crypto.SecretKey;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;

import java.time.Duration;

@Service
public class TokenService {

   public static final SecretKey key = Jwts.SIG.HS256.key().build();

   public String generateToken(UserDetails userDetails){

        Instant issuedAt = Instant.now();
        Instant expiration = issuedAt.plus(Duration.ofHours(1));

       

        return Jwts.builder()
        .issuer("SpringDev")
        .claim("user", userDetails)
        .subject(userDetails.getUsername())
        .issuedAt(Date.from(issuedAt))
        .expiration(Date.from(expiration))
        .signWith(key)
        .compact().toString();
    }
    
}
