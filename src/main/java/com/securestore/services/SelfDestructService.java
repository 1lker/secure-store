package com.securestore.services;

public class SelfDestructService {
    public void triggerSelfDestruct() {
        // Şifreleme anahtarlarını silme
        KeyManagementService keyService = new KeyManagementService();
        keyService.wipeAllKeys();

        // Tüm dosyaları okunamaz hale getirme
        FileSystemService fileSystemService = new FileSystemService();
        fileSystemService.corruptAllFiles();
    }
}
