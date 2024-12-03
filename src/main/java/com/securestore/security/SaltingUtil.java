package com.securestore.security;

import java.security.SecureRandom;

// SaltingUtil.java
public class SaltingUtil {
    public static byte[] generateSalt() {
        byte[] salt = new byte[16]; // 128-bit salt
        new SecureRandom().nextBytes(salt);
        return salt;
    }
}
