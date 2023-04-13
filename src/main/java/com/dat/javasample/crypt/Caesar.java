package com.dat.javasample.crypt;


public class Caesar extends Cryptography {
    public Caesar(String plainText,String space,String cipherText) {
        super(plainText,space,cipherText);
    }

    public void encode() {
        cipherText = "";
        int space=Integer.parseInt(super.key);
        for (int i = 0; i < plainText.length(); i++)
            cipherText += (char)(mod_26((plainText.charAt(i)+ space- 'A' ))+'A');
    }

    @Override
    public void decode() {
        plainText = "";
        int space=Integer.parseInt(super.key);
        for (int i = 0; i < cipherText.length(); i++)
            plainText += (char)(mod_26((cipherText.charAt(i)- space- 'A' ))+'A');
    }

    private int mod_26(int a){
        while(a<0)a=a+ 26;
        return a% 26;
    }
}
