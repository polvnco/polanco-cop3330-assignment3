/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Polanco
 */
package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class wordFrequencyFinder {
    public static void main(String[] args) throws IOException {
        wordFrequencyFinder iFrequent = new wordFrequencyFinder();
        iFrequent.readFile();
        iFrequent.reportFrequency();
    }

    /**
     * This method will attempt to look and find .txt
     * Once found, scan document and make into a string
     * return string to method once complete...
     * @return Scanner
     */
    public Scanner readFile() throws FileNotFoundException {
        String fileName = ("src/main/java/ex46/exercise46_input.txt");
        return new Scanner(new File(fileName));
    }

    /**
     * Will need to map what is read from the .txt
     * In a loop, read next word
     *      if it contains something, start a counter
     * Once there are no more words, return the counter
     * @return the counter
     */

    public Map<String, Integer> createMap() throws IOException {
        var input = readFile();

        Map<String, Integer> wordCounts = new TreeMap<>();
        while (input.hasNext()) {
            String next = input.next().toLowerCase();
            if (!wordCounts.containsKey(next)) {
                wordCounts.put(next, 1);
            } else {
                wordCounts.put(next, wordCounts.get(next) + 1);
            }
        }
        return wordCounts;

    }

    /**
     *Take in the word counts from the strings and integers,
     * Set word to be checked against the counter
     * Print the word along with its count being counted
     */
    public void reportFrequency() throws IOException {
        var wordCounts = createMap();

        for (String word : wordCounts.keySet()) {
            int count = wordCounts.get(word);
            System.out.printf("%-8s: %-10s%n", word, "*".repeat(Math.max(0, count)));
        }
    }
}