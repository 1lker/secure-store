package com.securestore.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;

public class HashUtil {
    public static String generateSHA512Hash(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] digest = md.digest(data);
        return Hex.encodeHexString(digest);
    }
}
