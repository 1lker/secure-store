package com.securestore.security;

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class ECCKeyExchange {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public KeyPair generateECCKeyPair() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC", "BC");
        keyPairGenerator.initialize(new ECGenParameterSpec("secp256r1"), new SecureRandom());
        return keyPairGenerator.generateKeyPair();
    }
}
