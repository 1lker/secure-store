package com.securestore.models;

public class EncryptedFile {
    private byte[] encryptedContent;
    private byte[] encryptedMetadata;

    public EncryptedFile(byte[] encryptedContent, byte[] encryptedMetadata) {
        this.encryptedContent = encryptedContent;
        this.encryptedMetadata = encryptedMetadata;
    }

    // Getter ve Setter metotları

    public byte[] getEncryptedContent() {
        return encryptedContent;
    }

    public void setEncryptedContent(byte[] encryptedContent) {
        this.encryptedContent = encryptedContent;
    }

    public byte[] getEncryptedMetadata() {
        return encryptedMetadata;
    }

    public void setEncryptedMetadata(byte[] encryptedMetadata) {
        this.encryptedMetadata = encryptedMetadata;
    }
}
