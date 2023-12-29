package org.dat.javasample.crypt;

public class Transposition {
    public static String decoding(String cipherText, int[] key) {
        int n = cipherText.length() / key.length;
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int k : key) {
                plainText.append(cipherText.charAt((k - 1) * n + i));
                System.out.print(plainText.charAt(plainText.length() - 1));
            }
            System.out.println();
        }
        return plainText.toString();
    }

    public static String encoding(String plainText, int[] key) {
        int n = plainText.length() / key.length;
        StringBuilder cipherText = new StringBuilder(plainText);
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int k : key)
                cipherText.setCharAt((k - 1) * n + i, plainText.charAt(index++));
            for (int j = 0; j < key.length; j++)
                System.out.print(cipherText.charAt(j * n + i));
            System.out.println();
        }
        return cipherText.toString();
    }
}


