package com.securestore.services;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class KeyManagementService {
    private Map<String, List<SecretKey>> keyVersioning = new HashMap<>();

    public SecretKey rotateKey(String fileId) throws NoSuchAlgorithmException {
        SecretKey newKey = generateNewKey();
        keyVersioning.computeIfAbsent(fileId, k -> new ArrayList<>()).add(newKey);
        // Yeni anahtar sürümünü güvenli bir şekilde saklama
        storeKeyVersion(fileId, newKey);
        return newKey;
    }

    private SecretKey generateNewKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        return keyGen.generateKey();
    }

    private void storeKeyVersion(String fileId, SecretKey key) {
        // Anahtarın güvenli bir şekilde saklanması (örneğin, bir anahtar yönetim sistemi kullanarak)
        System.out.println("Anahtar sürümü kaydedildi: " + fileId);
    }

    public void wipeAllKeys() {
        keyVersioning.clear();
        System.out.println("Tüm anahtarlar silindi.");
    }
}
