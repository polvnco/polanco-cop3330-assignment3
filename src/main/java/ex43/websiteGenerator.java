/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Polanco
 */
package ex43;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class websiteGenerator {
    public static void main(String[] args) {
        websiteGenerator run = new websiteGenerator();
        try {
            run.makeDir();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getSite() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Site name: ");
        return scanner.next();
    }

    public String getAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Author: ");
        return scanner.nextLine();
    }


    public boolean getJavaScript() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want a folder for JavaScript? ");
        return scanner.nextLine().equals("y");
    }

    public boolean CSS() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want a folder for CSS? ");
        return scanner.next().equals("y");
    }

    private void makeDir() throws IOException {
        var site = getSite();
        var a = getAuthor();
        var js = getJavaScript();
        var css = CSS();

        String directory_Author = "./src/main/java/ex43/website/" + site;
        File authorDirectory = new File(directory_Author);

        if (!authorDirectory.exists()) {
            if (authorDirectory.mkdirs()) {
                System.out.printf("Created ./website/%s%n", site);
            } else {
                System.out.println("yikes");
            }
        }

        var filePath = new File(String.format("./src/main/java/ex43/website/%s/index.html", site));

        try (var writeToFile = new BufferedWriter(new FileWriter(filePath))) {
            writeToFile.write(String.format("<!DOCTYPE html>%n<html>%n<head>%n"));
            writeToFile.write(String.format("<title>%s</title>%n", site));
            writeToFile.write(String.format("<meta name=\"author\" content=\"%s\">%n", a));
        }

        System.out.printf("Created ./website/%s" + "/index.html%n", site);


        String directory_js = "./src/main/java/ex43/website/" + site + "/js";
        File jsDirectory = new File(directory_js);

        String directory_css = "./src/main/java/ex43/website/" + site + "/css";
        File cssDirectory = new File(directory_css);

        if (!jsDirectory.exists() && js) {
            if (jsDirectory.mkdirs()) {
                System.out.println("Created ./website/" + site + "/js/");
            } else {
                System.out.println("yikes");
            }
        }
        if (!cssDirectory.exists() && css) {
            if (cssDirectory.mkdirs()) {
                System.out.println("Created ./website/" + site + "/css/");
            } else {
                System.out.println("yikes");
            }
        }
    }
}
