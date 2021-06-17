/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Polanco
 */
package ex42;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class parseDataFile {
    public static void main(String[] args) throws Throwable {
        List<emp> names;
        names = readFile();
        assert names != null;
        print(names);
    }

    /**
     * Create space for strings
     * Read strings from File Input
     * Set variable containing read strings
     * Return variable containing strings from file
     */
    private static List<emp> readFile() throws Throwable {
        var names = new ArrayList<emp>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/ex42/exercise42_input.txt"))) {
            names = bufferedReader.lines().map(line -> line.split(",")).filter(parts -> parts.length > 1).map(parts -> new emp(parts[1], parts[0], parts[2])).collect(Collectors.toCollection(ArrayList::new));
        }
        return names;
    }

    /**
     * Print each name and salary in a new line until there are no names left
     */
    private static void print(List<emp> names) {
            System.out.println("Last      First     Salary");
            System.out.println("--------------------------");
            for (emp name : names) {
                System.out.println(name);
            }
        }



    private record emp(String firstName, String lastName, String salary) {

        public String toString() {
            return String.format("%-9s %-9s %s", lastName, firstName, salary);
        }

    }
}

