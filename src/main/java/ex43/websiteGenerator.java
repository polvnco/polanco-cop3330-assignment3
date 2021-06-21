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

    private boolean jsFolder;
    private boolean cssFolder;
    private String author;
    private String site;

    public websiteGenerator(String setAuthor, String setSite, boolean setJavaScript, boolean setCSS){
        this.author = setAuthor;
        this.site = setSite;
        this.jsFolder = setJavaScript;
        this.cssFolder = setCSS;

    }



    public static void main(String[] args) {
        try {
            makeDir();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String callSite() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Site name: ");
        return scanner.next();
    }

    public static String callAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Author: ");
        return scanner.nextLine();
    }


    public static boolean callJavaScript() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want a folder for JavaScript? ");
        return scanner.nextLine().equals("y");
    }

    public void setAuthor(String scanString){
        this.author = scanString;
    }

    public String getAuthor() {
        return callAuthor();
    }

    public void setSite(String scanString){
        this.site = scanString;
    }

    public String getSite(){
        return callSite();
    }

    public void setJavaScript(boolean javaScript){
        this.jsFolder = javaScript;
    }

    public boolean getJavaScript(){
        return callJavaScript();
    }

    public void setCSS(boolean scanner){
        this.cssFolder = scanner;
    }

    public boolean getCSS(){
        return callCSS();
    }

    public static boolean callCSS() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want a folder for CSS? ");
        return scanner.next().equals("y");
    }

    private static void makeDir() throws IOException {
        var site = callSite();
        var a = callAuthor();
        var js = callJavaScript();
        var css = callCSS();

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
