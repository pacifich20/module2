package com.pacifich20.module2.v5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class CaesarCipherCracker {

    // list of words used for validation
    private final List<String> words;

    /**
     * creates a caesar cipher cracker with list of words obtained from a file
     * @param wordsFile file containing list of words
     */
    public CaesarCipherCracker(File wordsFile) {
        this.words = readWordsFromFile(wordsFile);
    }

    /**
     * reads list of words from file and returns them in list form
     * @param file file containing words
     * @return list of words
     * @throws RuntimeException when error reading file occurs
     */
    private List<String> readWordsFromFile(File file) {
        try {
            return Files.lines(file.toPath())
                    .flatMap(line -> List.of(line.split("\\s+")).stream())
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error reading words file", e);
        }
    }

    /**
     * finds shift value for decrypting encrypted message so resulting message contains only valid words
     * @param message encrypted message
     * @return shift value
     */
    public int findShift(String message) {
        int shift = 1;
        while (shift < 26) {
            String decryptedMessage = new CaesarCipher(shift).decrypt(message);
            if (isValidDecryption(decryptedMessage)) {
                break;
            }
            shift++;
        }
        return shift;
    }

    /**
     * checks if decrypted message contains only valid words
     * @param decryptedMessage decrypted message
     * @return true if valid message, false otherwise.
     */
    private boolean isValidDecryption(String decryptedMessage) {
        return List.of(decryptedMessage.split("\\s+")).stream()
                .allMatch(word -> words.contains(word));
    }

    /**
     * decrypts encrypted message using shift value
     * @param message encrypted message
     * @return decrypted message
     */
    public String decrypt(String message) {
        int shift = findShift(message);
        return new CaesarCipher(shift).decrypt(message);
    }

}