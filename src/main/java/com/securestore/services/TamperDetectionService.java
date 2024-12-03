package com.securestore.services;

import com.securestore.security.HashUtil;

import java.security.NoSuchAlgorithmException;

public class TamperDetectionService {
    private String originalHash;

    public void recordOriginalState(byte[] data) throws NoSuchAlgorithmException {
        originalHash = HashUtil.generateSHA512Hash(data);
    }

    public boolean isTampered(byte[] currentData) throws NoSuchAlgorithmException {
        String currentHash = HashUtil.generateSHA512Hash(currentData);
        return !originalHash.equals(currentHash);
    }
}
