package com.securestore.services;

import java.time.Instant;

public class AuditLogService {
    public void logFileInteraction(String userId, String fileId, String action) {
        String timestamp = Instant.now().toString();
        String deviceInfo = getDeviceInfo();
        String logEntry = String.format("%s | User: %s | File: %s | Action: %s | Device: %s",
                timestamp, userId, fileId, action, deviceInfo);
        // Log kaydını saklama (örneğin, dosya veya veritabanı)
        System.out.println("Log: " + logEntry);
    }

    private String getDeviceInfo() {
        // Cihaz bilgilerini alma (örneğin, MAC adresi)
        return "DeviceInfo";
    }
}
