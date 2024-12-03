package com.securestore.security;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import java.io.ByteArrayOutputStream;
import java.security.*;

public class HybridEncryptionUtil {
    public byte[] encryptData(byte[] data, PublicKey publicKey) throws Exception {
        // AES oturum anahtarı oluşturma
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey aesKey = keyGen.generateKey();

        // Veriyi AES anahtarı ile şifreleme
        Cipher aesCipher = Cipher.getInstance("AES/GCM/NoPadding");
        byte[] iv = new byte[12]; // GCM için 96-bit IV
        new SecureRandom().nextBytes(iv);
        GCMParameterSpec spec = new GCMParameterSpec(128, iv);
        aesCipher.init(Cipher.ENCRYPT_MODE, aesKey, spec);
        byte[] encryptedData = aesCipher.doFinal(data);

        // AES anahtarını ECC açık anahtarı ile şifreleme
        Cipher eccCipher = Cipher.getInstance("ECIES", "BC");
        eccCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedKey = eccCipher.doFinal(aesKey.getEncoded());

        // Şifrelenmiş veriyi ve şifrelenmiş anahtarı birleştirme
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(iv.length);
        outputStream.write(iv);
        outputStream.write(encryptedKey.length);
        outputStream.write(encryptedKey);
        outputStream.write(encryptedData);

        return outputStream.toByteArray();
    }
}
