package com.TheAngels.project.service;

public interface EncryptService {
    /* Encripta el password */
    String encryptPassword(String password);

    /* Verifica que el password y el encriptado sean el mismo */
    Boolean verifyPassword(String password, String hashPassword);
}
