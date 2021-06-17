/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Polanco
 */
package ex41;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class nameSorter {
    public static void main(String[] args) throws Throwable {
        List<Name> names;
        names = readFile();
        assert names != null;
        Collections.sort(names);
        writeFile(names);
    }

    /**
     * Create space for strings
     * Read strings from File Input
     * Set variable containing read strings
     * Return variable containing strings from file
     */
    private static List<Name> readFile() throws Throwable {
        var names = new ArrayList<Name>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/ex41/exercise41_input.txt"))) {
            names = bufferedReader.lines().map(line -> line.split(", ")).filter(parts -> parts.length > 1).map(parts -> new Name(parts[1], parts[0])).collect(Collectors.toCollection(ArrayList::new));
        }
        return names;
    }

    /**
     * Create and write to new file
     * Take size of array list to output # of names correctly
     * Print each name in a new line until there are no names left
     */
    private static void writeFile(List<Name> names) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("src/main/java/ex41/exercise41_output.txt"))) {
            printWriter.printf("Total of %d names%n", names.size());
            printWriter.println("-----------------");
            for (Name name : names) {
                printWriter.println(name);
            }
        }
    }


    private record Name(String firstName, String lastName) implements Comparable<Name> {

        public int compareTo(Name other) {
            if (this == other) {
                return 0;
            } else if (Objects.equals(lastName, other.getLast())) {
                return firstName.compareTo(other.getFirst());
            } else {
                return lastName.compareTo(other.getLast());
            }
        }

        public String toString() {
            return String.format("%s, %s", lastName, firstName);
        }
        private String getFirst() {
            return firstName;
        }

        private String getLast() {
            return lastName;
        }
    }
}