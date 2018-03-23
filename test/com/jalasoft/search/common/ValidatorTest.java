package com.jalasoft.search.common;
import org.junit.jupiter.api.Test;

import static com.jalasoft.search.common.Validator.isDirectory;
import static com.jalasoft.search.common.Validator.isFileExist;
import static com.jalasoft.search.common.Validator.isValidPath;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    @Test
    public void validatePathIsValid() {
        assertTrue(isValidPath("C:\\TestFolder"));
        assertTrue(isValidPath("\\TestFiles"));
    }

    @Test
    public void validatePathIsInvalid() {
        assertFalse(isValidPath("C:\\TestF/-*-*/**olderFake"));
        assertFalse(isValidPath("\\TestF/*-*ilesFake"));
    }

    @Test
    public void validateIfFileExist() {
        //assertTrue(isFileExist("C:\\TestFolder"));
        assertTrue(isFileExist("TestFiles"));
    }

    @Test
    public void validateFileDoesNotExist() {
        //assertFalse(isFileExist("H:\\TestFolder"));
        assertFalse(isFileExist("TestFilesFake"));
    }

    @Test
    public void validateIfFileIsDirectory() {
        assertTrue(isDirectory("C:\\TestFolder"));
        //assertTrue(isFileExist("\\TestFiles"));
    }

    @Test
    public void validateFileIsNotDirectory() {
        assertFalse(isDirectory("C:\\TestFolder\\Test.txt"));
        //assertFalse(isFileExist("\\TestFilesFake"));
    }
}
