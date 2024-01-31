package com.pacifich20.module2.v5;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        CaesarCipherCracker cracker = new CaesarCipherCracker(new File("C:\\Users\\Pdog\\IdeaProjects\\module2\\src\\com\\pacifich20\\module2\\v5\\words_alpha.txt"));

        CaesarCipher shift2 = new CaesarCipher(2);
        CaesarCipher shift3 = new CaesarCipher(3);

        String encryptedMessageShift2 = shift2.encrypt("my dad died in a tragic plane crash last night");
        String encryptedMessageShift3 = shift3.encrypt("me when i lie");

        System.out.println("Encrypted message: " + encryptedMessageShift2);
        String decryptedMessageShift2 = shift2.decrypt(encryptedMessageShift2);
        System.out.println("Decrypted message: " + decryptedMessageShift2);
        int crack2 = cracker.findShift(encryptedMessageShift2);
        System.out.println("Shift for message: " + crack2);
        String decryptedMessage2 = cracker.decrypt(encryptedMessageShift2);
        System.out.println("Decrypted message: " + decryptedMessage2);

        System.out.println("Encrypted message: " + encryptedMessageShift3);
        String decryptedMessageShift3 = shift3.decrypt(encryptedMessageShift3);
        System.out.println("Decrypted message: " + decryptedMessageShift3);
        int crack3 = cracker.findShift(encryptedMessageShift3);
        System.out.println("Shift for message: " + crack3);
        String decryptedMessage3 = cracker.decrypt(encryptedMessageShift3);
        System.out.println("Decrypted message: " + decryptedMessage3);


    }
}
