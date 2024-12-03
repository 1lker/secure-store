package com.securestore.services;

import com.securestore.models.UserBehavior;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;


public class AdaptiveEncryptionService {
    public SecretKey selectEncryptionKey(String fileSensitivity, UserBehavior behavior) throws NoSuchAlgorithmException {
        // Basit AI simülasyonu
        if ("HIGH".equals(fileSensitivity) && behavior.isAnomalous()) {
            return generateKey(256);
        } else {
            return generateKey(128);
        }
    }

    private SecretKey generateKey(int keySize) throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(keySize);
        return keyGen.generateKey();
    }
}
