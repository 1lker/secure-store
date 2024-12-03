package com.securestore.services;

import com.securestore.models.EncryptedFile;
import com.securestore.security.SaltingUtil;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class FileEncryptionService {
    public EncryptedFile encryptFile(File file, SecretKey key) throws Exception {
        // Dosya içeriğini şifreleme
        byte[] fileContent = Files.readAllBytes(file.toPath());
        byte[] encryptedContent = encryptData(fileContent, key);

        // Meta veriyi şifreleme
        String metadata = getFileMetadata(file);
        byte[] encryptedMetadata = encryptData(metadata.getBytes(), key);

        return new EncryptedFile(encryptedContent, encryptedMetadata);
    }

    private byte[] encryptData(byte[] data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        byte[] iv = new byte[12]; // GCM için 96-bit IV
        new SecureRandom().nextBytes(iv);
        GCMParameterSpec spec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, spec);
        byte[] encrypted = cipher.doFinal(data);

        // IV'yi şifrelenmiş veriye ekleyelim
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(iv);
        outputStream.write(encrypted);
        return outputStream.toByteArray();
    }

    private String getFileMetadata(File file) {
        // Meta veri çıkarma (örnek olarak dosya adı ve boyutu)
        return "Name:" + file.getName() + ";Size:" + file.length();
    }
}
