package com.TheAngels.project.service;

public interface JwtService {
    String buildJwt();

    Boolean validateJwt(String jwt);
}
