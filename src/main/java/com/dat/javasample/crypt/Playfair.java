package com.dat.javasample.crypt;

import java.util.Arrays;

public class Playfair {
    private String plainText;
    private String keyWord;
    private String cipherText;

    public Playfair(String plainText, String keyWord, String cipherText) {
        this.plainText = plainText;
        this.keyWord = keyWord;
        this.cipherText = cipherText;
    }

    public String getPlainText() {
        if (cipherText != null) decode();
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getKeyword() {
        return keyWord;
    }

    public void setKeyword(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getCipherText() {
        if (plainText != null) encode();
        return cipherText;
    }

    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }

    private StringBuilder table;
    private int[] index;

    private void createTable() {
        String temp = this.keyWord + "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        index = new int['Z' + 1];
        Arrays.fill(index, -1);
        table = new StringBuilder();
        for (int i = 0, k = 0; i < temp.length() && k < 25; i++)
            if (index[temp.charAt(i)] == -1) {
                table.append(temp.charAt(i));
                index[temp.charAt(i)] = k++;
            }
        index['J'] = index['I'];
    }

    private StringBuilder changeCode(String text, byte step) {
        StringBuilder cipherText = new StringBuilder();
        if (text.length() % 2 == 1) text += "X";
        createTable();
        for (int i = 0; i < text.length() - 1; i += 2) {
            int first = index[text.charAt(i)];
            int last = index[text.charAt(i + 1)];
            if (last / 5 == first / 5) {
                cipherText.append(table.charAt((first + step) % 5));
                cipherText.append(table.charAt((last + step) % 5));
            } else if (last % 5 == first % 5) {
                cipherText.append(table.charAt((first + step * 5) % 25));
                cipherText.append(table.charAt((last + step * 5) % 25));
            } else {
                cipherText.append(table.charAt((5 * (first / 5) + last % 5) % 25));
                cipherText.append(table.charAt((5 * (last / 5) + first % 5) % 25));
            }
        }
        return cipherText;
    }

    public void encode() {
        cipherText = changeCode(plainText, (byte) 1).toString();
    }

    public void decode() {
        plainText = changeCode(cipherText, (byte) 4).toString();
    }

    public String toString() {
        if (keyWord == null) return null;
        if (plainText == null)
            if (cipherText == null) return null;
            else decode();
        else encode();
        return this.plainText + "\n" + this.keyWord + "\n" + this.cipherText;
    }
}
