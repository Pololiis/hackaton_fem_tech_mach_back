package com.TheAngels.project.service;

import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EncryptServiceImpl implements EncryptService {
    @Override
    public String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    @Override
    public Boolean verifyPassword(String password, String hashPassword) {
        return BCrypt.checkpw(password, hashPassword);
    }
}
