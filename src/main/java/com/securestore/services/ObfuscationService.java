package com.securestore.services;

import java.util.Random;

public class ObfuscationService {
    public byte[] obfuscate(byte[] data) {
        data = layerOneObfuscation(data);
        data = layerTwoObfuscation(data);
        return data;
    }

    private byte[] layerOneObfuscation(byte[] data) {
        // XOR ile basit bir gizleme
        byte[] obfuscated = new byte[data.length];
        byte pattern = (byte) 0xAA;
        for (int i = 0; i < data.length; i++) {
            obfuscated[i] = (byte) (data[i] ^ pattern);
        }
        return obfuscated;
    }

    private byte[] layerTwoObfuscation(byte[] data) {
        // Byte dizisini karıştırma
        Random rnd = new Random();
        for (int i = data.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            byte temp = data[index];
            data[index] = data[i];
            data[i] = temp;
        }
        return data;
    }
}
