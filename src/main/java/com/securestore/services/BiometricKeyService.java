package com.securestore.services;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

public class BiometricKeyService {
    public SecretKey generateKeyFromBiometrics(byte[] biometricData) throws Exception {
        // Biyometrik veriden anahtar oluşturma
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] keyBytes = digest.digest(biometricData);
        return new SecretKeySpec(keyBytes, 0, 16, "AES");
    }
}
