package com.TheAngels.project.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Transactional
public class JwtServiceImpl implements JwtService {
    private final String secretKey = "9b874e186a4b6929c02743e8b8b303eb735d5dd56697f53dcad1df10c2c214481128d7c45185e67fd767c6a13503887dd8ddc185cc66d1dc9ccf666f02e0f9c8";

    @Override
    public String buildJwt() {
        int EXPIRATION_IN_MINUTES = 3;
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = new Date(issuedAt.getTime() + (EXPIRATION_IN_MINUTES * 60 * 1000));

        return Jwts.builder()
                .header()
                .type("JWT")
                .and()
                .expiration(expiration)
                .issuedAt(issuedAt)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    @Override
    public Boolean validateJwt(String jwt) {
        try {

            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .build()
                    .parseSignedClaims(jwt);

            Claims body = claims.getBody();

            Date expirationDate = body.getExpiration();
            Date now = new Date();

            return !expirationDate.before(now);

        } catch (Exception e) {
            return false;
        }
    }

}
