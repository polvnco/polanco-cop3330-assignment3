/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Polanco
 */
package ex45;

import java.io.*;
import java.util.Scanner;

public class wordFinder {
    public static void main(String[] args) throws IOException {
        modifyFile();
    }

    static void modifyFile() throws IOException {
        File fileToBeModified = new File("src/main/java/ex45/exercise45_input.txt");

        StringBuilder oldContent = new StringBuilder();
        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));


            var line = reader.readLine();

            while (line != null) {
                oldContent.append(line).append(System.lineSeparator());

                line = reader.readLine();
            }

            var newContent = oldContent.toString().replaceAll("utilize", "use");

            var newFile = new Scanner(System.in);
            System.out.print("What is the name of the output file? ");
            var string = newFile.nextLine();

            var file = new File("src/main/java/ex45/" + string);

            writer = new FileWriter(file);

            writer.write(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert reader != null;
            reader.close();

            assert writer != null;
            writer.close();
        }
    }
}
