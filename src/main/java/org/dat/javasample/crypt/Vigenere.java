package org.dat.javasample.crypt;

public class Vigenere extends Cryptography {

    public Vigenere(String plainText, String key, String cipherText) {
        super(plainText, key, cipherText);
    }

    private char atCipher(char row, char column) {
        return (char) ((row + column) % 26 + 'A');
    }

    private char getKeyChar(char plain, char cipher) {
        int value = cipher - plain;
        if (value < 0) value += 26;
        return (char) (value + 65);
    }

    private String createKeyText(String key, int length) {
        StringBuilder temp = new StringBuilder(key);
        while (temp.length() < length)
            temp.append(key);
        return temp.substring(0, length);
    }

    private String returnKeyText(String plainText, String cipherText) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++)
            temp.append(getKeyChar(plainText.charAt(i), cipherText.charAt(i)));
        return temp.toString();
    }

    public void encode() {
        String keyText = createKeyText(key, plainText.length());
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++)
            temp.append(atCipher(plainText.charAt(i), keyText.charAt(i)));
        cipherText = temp.toString();
    }

    @Override
    public void decode() {

    }

    private String returnKeyWord(String keyText) {
        int length = keyText.length();
        for (int i = 1; i < length / 2; i++) {
            String temp = keyText.substring(0, i);
            if (temp.equals(keyText.substring(i, i + i)))
                if (createKeyText(temp, length).equals(keyText)) return temp;
        }
        for (int i = length / 2; i < length; i++) {
            String temp = keyText.substring(0, i);
            if (createKeyText(temp, length).equals(keyText)) return temp;
        }
        return keyText;
    }

    public void returnKeyWord() {
        super.key = returnKeyWord(returnKeyText(plainText, cipherText));
    }

    @Override
    public String toString() {
        return super.getPlainText() + "\n" + super.getKey() + "\n" + super.getCipherText();
    }
}
