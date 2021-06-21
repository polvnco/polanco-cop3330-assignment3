/*
 *
 *  *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  *  Copyright 2021 Christopher Polanco
 *
 */

package ex43;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

class websiteGeneratorTest {

    private String siteName = "notAwesomeCo";
    private String siteAuthor = "notAwesomePerson";

    @Test
    void should_pass_if_jsFolder_created() {
        websiteGenerator wg = new websiteGenerator(siteName, siteAuthor, true, true);
        Path expectedJS = Paths.get("src/main/java/ex43/website/notAwesomeCO/js");
        wg.setJavaScript(true);
        assertTrue(Files.exists(expectedJS));
    }

    @Test
    void should_pass_if_cssFolder_created() {
        websiteGenerator wg = new websiteGenerator(siteName, siteAuthor, true, true);
        Path expectedCSS = Paths.get("src/main/java/ex43/website/notAwesomeCO/css");
        wg.setCSS(true);
        assertTrue(Files.exists(expectedCSS));
    }


}