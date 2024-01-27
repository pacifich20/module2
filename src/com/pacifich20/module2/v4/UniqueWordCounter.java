package com.pacifich20.module2.v4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueWordCounter {

    /**
     * reads file and prints number of unique words
     */
    public static void main(String[] args) {
        try {
            Set<String> uniqueWords = getUniqueWords("C:\\Users\\Pdog\\IdeaProjects\\module2\\src\\com\\pacifich20\\module2\\v4\\illiad.txt");
            System.out.println("Unique word count: " + uniqueWords.size());
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    /**
     * reads file, processes content, and returns set of unique words
     * @param fileName name of file to read
     * @return set containing all unique words found in file
     * @throws FileNotFoundException when file is not found
     */
    private static Set<String> getUniqueWords(String fileName) throws FileNotFoundException {
        Set<String> uniqueWords = new HashSet<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-z0-9]", "");
                uniqueWords.add(word);
            }
        }

        return uniqueWords;
    }
}
