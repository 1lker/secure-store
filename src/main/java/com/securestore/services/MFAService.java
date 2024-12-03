package com.securestore.services;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

public class MFAService {
    private final GoogleAuthenticator gAuth = new GoogleAuthenticator();

    public GoogleAuthenticatorKey generateSecretKey() {
        return gAuth.createCredentials();
    }

    public boolean authorize(String secretKey, int verificationCode) {
        return gAuth.authorize(secretKey, verificationCode);
    }
}
