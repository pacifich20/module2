package com.pacifich20.module2.v5;

import java.util.HashMap;
import java.util.Map;

public class CaesarCipher {

    private final Map<Character, Character> decryptionMap;
    private final Map<Character, Character> encryptionMap;

    /**
     * creates caesar cipher
     * @param shift shift value for encryption and decryption.
     * @throws IllegalArgumentException when shift not between 1-25
     */
    public CaesarCipher(int shift) {
        validateShift(shift);

        decryptionMap = new HashMap<>();
        encryptionMap = new HashMap<>();

        initializeMaps(shift);
    }

    /**
     * encrypts message using caesar cipher.
     * @param message message to encrypt
     * @return encrypted message.
     */
    public String encrypt(String message) {
        return translateString(message, encryptionMap);
    }

    /**
     * decrypts message using caesar cipher.
     *
     * @param message message to decrypt
     * @return decrypted message
     */
    public String decrypt(String message) {
        return translateString(message, decryptionMap);
    }

    /**
     * translates string using provided translation map
     * @param ogMessage original message to translate
     * @param translationMap map used to translate
     * @return translated message
     */
    private String translateString(String ogMessage, Map<Character, Character> translationMap) {
        StringBuilder translation = new StringBuilder();

        for (char c : ogMessage.toCharArray()) {
            if (Character.isLetter(c)) {
                translation.append(translationMap.get(Character.toLowerCase(c)));
            } else {
                translation.append(c);
            }
        }
        return translation.toString();
    }

    /**
     * validates shift value
     * @param shift shift value to validate
     * @throws IllegalArgumentException when shift not between 1-25.
     */
    private void validateShift(int shift) {
        if (shift <= 0 || shift > 25) {
            throw new IllegalArgumentException("Shift is not between 1-25, invalid");
        }
    }

    /**
     * initializes encryption and decryption maps based on shift value
     * @param shift shift value used to initialize
     */
    private void initializeMaps(int shift) {
        for (int i = 0; i < 26; i++) {
            char plainChar = (char) ('a' + i);
            char encryptedChar = (char) ('a' + ((i + shift) % 26));
            encryptionMap.put(plainChar, encryptedChar);
            decryptionMap.put(encryptedChar, plainChar);
        }
    }
}