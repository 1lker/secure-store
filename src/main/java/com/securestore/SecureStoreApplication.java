package com.securestore;

import com.securestore.models.EncryptedFile;
import com.securestore.models.UserBehavior;
import com.securestore.security.ECCKeyExchange;
import com.securestore.security.HybridEncryptionUtil;
import com.securestore.services.*;

import javax.crypto.SecretKey;
import java.io.File;
import java.security.KeyPair;

public class SecureStoreApplication {
    public static void main(String[] args) throws Exception {
        // Servisleri başlatma
        DeviceRegistrationService deviceRegService = new DeviceRegistrationService();
        MFAService mfaService = new MFAService();
        ECCKeyExchange eccKeyExchange = new ECCKeyExchange();
        HybridEncryptionUtil hybridEncryptionUtil = new HybridEncryptionUtil();
        FileEncryptionService fileEncryptionService = new FileEncryptionService();
        AdaptiveEncryptionService adaptiveEncryptionService = new AdaptiveEncryptionService();
        AccessControlService accessControlService = new AccessControlService();
        AuditLogService auditLogService = new AuditLogService();
        TamperDetectionService tamperDetectionService = new TamperDetectionService();
        // AnomalyDetectionService anomalyDetectionService = new AnomalyDetectionService();
        BiometricKeyService biometricKeyService = new BiometricKeyService();

        // Kullanıcı ve cihaz bilgileri
        String macId = "00:1B:44:11:3A:B7";
        String deviceFingerprint = "DeviceFingerprint123";
        String userCredentials = "UserPassword";
        String userId = "user123";
        String fileId = "file123";
        String fileSensitivity = "HIGH";

        // Cihaz kaydı ve MFA
        String deviceToken = deviceRegService.registerDevice(macId, deviceFingerprint, userCredentials);
        System.out.println("Cihaz Belirteci: " + deviceToken);

        // MFA işlemi
        var secretKey = mfaService.generateSecretKey();
        System.out.println("MFA Gizli Anahtarı: " + secretKey.getKey());

        // Kullanıcıdan alınan doğrulama kodu (örneğin, 123456)
        int userInputCode = 123456;
        boolean isVerified = mfaService.authorize(secretKey.getKey(), userInputCode);
        System.out.println("MFA Doğrulaması: " + isVerified);

        // ECC anahtar çifti oluşturma
        KeyPair eccKeyPair = eccKeyExchange.generateECCKeyPair();

        // Kullanıcı davranışı (normal veya anormal)
        UserBehavior userBehavior = new UserBehavior();
        userBehavior.setAnomalous(false);

        // Uyumlu şifreleme anahtarı seçimi
        SecretKey sessionKey = adaptiveEncryptionService.selectEncryptionKey(fileSensitivity, userBehavior);

        // Dosya şifreleme
        File file = new File("secure_files/sample.txt");
        EncryptedFile encryptedFile = fileEncryptionService.encryptFile(file, sessionKey);
        System.out.println("Dosya şifrelendi.");

        // Kurcalama tespiti için orijinal durumu kaydetme
        byte[] originalData = encryptedFile.getEncryptedContent();
        tamperDetectionService.recordOriginalState(originalData);

        // Dosya üzerinde işlem yapıldıktan sonra (örneğin, kurcalama)
        byte[] currentData = encryptedFile.getEncryptedContent(); // Bu örnekte değişmedi

        if (tamperDetectionService.isTampered(currentData)) {
            System.out.println("Kurcalama tespit edildi!");
            SelfDestructService selfDestructService = new SelfDestructService();
            selfDestructService.triggerSelfDestruct();
        } else {
            System.out.println("Dosya güvenli.");
        }

        // Anomali tespiti
        AnomalyDetectionService anomalyDetectionService = new AnomalyDetectionService();
        double[] activityFeatures = new double[]{0.1, 0.5, 0.2}; // Örnek özellikler
        boolean isAnomalous = anomalyDetectionService.isAnomalousActivity(activityFeatures);
        if (isAnomalous) {
            System.out.println("Anormal etkinlik tespit edildi!");
            // Uygun önlemleri alın
        } else {
            System.out.println("Etkinlik normal.");
        }


        // Erişim kontrolü
        accessControlService.assignRole(userId, "ADMIN");
        if (accessControlService.hasAccess(userId, "READ")) {
            System.out.println("Kullanıcının dosyayı okuma izni var.");
            // Dosya okuma işlemi
        }

        // Loglama
        auditLogService.logFileInteraction(userId, fileId, "READ");
    }
}
