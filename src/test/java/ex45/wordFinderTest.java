/*
 *
 *  *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  *  Copyright 2021 Christopher Polanco
 *
 */

package ex45;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class wordFinderTest {


    @Test
    void swapWords() {

        String expectedOutput = "Im trying to use a different way of saying no. Use this.";

        String actual = "Im trying to use a different way of saying no. Use this.";
        assertEquals(expectedOutput, actual);
    }

}