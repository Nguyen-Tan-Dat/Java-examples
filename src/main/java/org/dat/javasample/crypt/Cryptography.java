package org.dat.javasample.crypt;

public abstract class Cryptography {
    protected String cipherText,key,plainText;

    public Cryptography(String plainText, String key, String cipherText) {
        this.cipherText = cipherText;
        this.key = key;
        this.plainText = plainText;
    }

    public String getCipherText() {
        if (plainText != null && key != null) encode();
        return cipherText;
    }

    public abstract void encode();

    public abstract void decode();

    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }
}
