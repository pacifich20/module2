package com.pacifich20.module2.v5;


public class Main {

    public static void main(String[] args) {

        CaesarCipher shift1 = new CaesarCipher(1);
        CaesarCipher shift2 = new CaesarCipher(2);
        CaesarCipher shift3 = new CaesarCipher(3);

        String encryptedMessageShift1 = shift1.encrypt("pikachu loves eating very big sitrus berries");
        String encryptedMessageShift2 = shift2.encrypt("my dad died in a tragic plane crash last night");
        String encryptedMessageShift3 = shift3.encrypt("me when i lie");

        System.out.println("Encrypted message: " + encryptedMessageShift1);
        String decryptedMessageShift1 = shift1.decrypt(encryptedMessageShift1);
        System.out.println("Decrypted message: " + decryptedMessageShift1);

        System.out.println("Encrypted message: " + encryptedMessageShift2);
        String decryptedMessageShift2 = shift2.decrypt(encryptedMessageShift2);
        System.out.println("Decrypted message: " + decryptedMessageShift2);

        System.out.println("Encrypted message: " + encryptedMessageShift3);
        String decryptedMessageShift3 = shift3.decrypt(encryptedMessageShift3);
        System.out.println("Decrypted message: " + decryptedMessageShift3);
        
        
    }
}
