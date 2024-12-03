package com.securestore.services;

public class FileFormatConverter {
    public byte[] convertToProprietaryFormat(byte[] fileData) {
        // Basit bir örnek: byte dizisini ters çevirme
        byte[] convertedData = new byte[fileData.length];
        for (int i = 0; i < fileData.length; i++) {
            convertedData[i] = fileData[fileData.length - i - 1];
        }
        return convertedData;
    }
}
