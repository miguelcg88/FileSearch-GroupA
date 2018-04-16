package src.com.jalasoft.search.common;




import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static src.com.jalasoft.search.common.Validator.*;


public class ValidatorTest {
    @Test
    public void validatePathIsValid() {
        //assertTrue(isValidPath("C:\\TestFolder"));
        Assertions.assertTrue(isValidPath("\\TestFiles"));
    }

    @Test
    public void validatePathIsInvalid() {
        //assertFalse(isValidPath("C:\\TestF/-*-*/**olderFake"));
        Assertions.assertFalse(isValidPath("\\TestF/*-*ilesFake"));
    }

    @Test
    public void validateIfFileExist() {
        //assertTrue(isFileExist("C:\\TestFolder"));
        Assertions.assertTrue(isFileExist(".\\test\\com\\jalasoft\\search\\common\\TestFiles"));
    }

    @Test
    public void validateFileDoesNotExist() {
        //assertFalse(isFileExist("H:\\TestFolder"));
        Assertions.assertFalse(isFileExist("TestFilesFake"));
    }

    @Test
    public void validateIfFileIsDirectory() {
        //assertTrue(isDirectory("C:\\TestFolder"));
        Assertions.assertTrue(isDirectory(".\\test\\com\\jalasoft\\search\\common\\TestFiles"));
    }

    @Test
    public void validateFileIsNotDirectory() {
        //assertFalse(isDirectory("C:\\TestFolder\\Test.txt"));
        Assertions.assertFalse(isDirectory("\\TestFilesFake"));
    }

    @Test
    public void validateDateIsValid(){
        Assertions.assertTrue(isValidDate("3/26/2018"));
    }

    @Test
    public void validateDateIsInvalid(){
        Assertions.assertFalse(isValidDate("13/26/2018"));
    }

    @Test
    public void validateFileHasValidExtension(){
        Assertions.assertTrue(isValidExtension("a.pdf"));
    }

    @Test
    public void validateFileNameDoesNotHaveValidExtension(){
        Assertions.assertFalse(isValidExtension("a.mp3"));
    }

    @Test
    public void validateStringIsAValidFileName(){
        Assertions.assertTrue(isValidName("HelloWorld"));
    }

    @Test
    public void validateStringIsInvalidFileName(){
        Assertions.assertFalse(isValidName("Hello*World"));
    }
}
