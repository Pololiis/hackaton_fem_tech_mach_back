package com.TheAngels.project.service;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {
    private final Integer EXPIRATION_IN_MINUTES = 5;

    @Override
    public String buildJwt() {
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = new Date(issuedAt.getTime() + (EXPIRATION_IN_MINUTES * 60 * 1000));

        String jwt = Jwts.builder()
                .header()
                .type("JWT")
                .and()
                .expiration(expiration)
                .issuedAt(issuedAt)
                .compact();

        return jwt;
    }
}
