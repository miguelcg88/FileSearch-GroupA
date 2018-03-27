package com.jalasoft.search.common;

import org.junit.jupiter.api.Test;
import static com.jalasoft.search.common.Validator.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    @Test
    public void validatePathIsValid() {
        //assertTrue(isValidPath("C:\\TestFolder"));
        assertTrue(isValidPath("\\TestFiles"));
    }

    @Test
    public void validatePathIsInvalid() {
        //assertFalse(isValidPath("C:\\TestF/-*-*/**olderFake"));
        assertFalse(isValidPath("\\TestF/*-*ilesFake"));
    }

    @Test
    public void validateIfFileExist() {
        //assertTrue(isFileExist("C:\\TestFolder"));
        assertTrue(isFileExist(".\\test\\com\\jalasoft\\search\\common\\TestFiles"));
    }

    @Test
    public void validateFileDoesNotExist() {
        //assertFalse(isFileExist("H:\\TestFolder"));
        assertFalse(isFileExist("TestFilesFake"));
    }

    @Test
    public void validateIfFileIsDirectory() {
        //assertTrue(isDirectory("C:\\TestFolder"));
        assertTrue(isDirectory(".\\test\\com\\jalasoft\\search\\common\\TestFiles"));
    }

    @Test
    public void validateFileIsNotDirectory() {
        //assertFalse(isDirectory("C:\\TestFolder\\Test.txt"));
        assertFalse(isDirectory("\\TestFilesFake"));
    }

    @Test
    public void validateDateIsValid(){
        assertTrue(isValidDate("3/26/2018"));
    }

    @Test
    public void validateDateIsInvalid(){
        assertFalse(isValidDate("13/26/2018"));
    }

    @Test
    public void validateFileHasValidExtension(){
        assertTrue(isValidExtension("a.pdf"));
    }

    @Test
    public void validateFileNameDoesNotHaveValidExtension(){
        assertFalse(isValidExtension("a.mp3"));
    }
}
