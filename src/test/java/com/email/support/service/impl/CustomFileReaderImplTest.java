package com.email.support.service.impl;

import com.email.support.service.CustomFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class CustomFileReaderImplTest {
    private static final String WRONG_PATH = "";
    private static final String WRONG_PATH2 = "12";
    private static final String EMPTY_PATH = "src/test/java/resources/empty-file.txt";
    private static final String CORRECT_PATH = "src/test/java/resources/file.txt";

    private static CustomFileReader fileReader;

    @BeforeAll
    static void beforeAll() {
        fileReader = new CustomFileReaderImpl();
    }

    @Test
    public void readFileWithWrongPath_ok() {
        Assertions.assertThrows(RuntimeException.class, () -> fileReader.readFile(WRONG_PATH));
    }

    @Test
    public void readFileWithWrongPath2_ok() {
        Assertions.assertThrows(RuntimeException.class, () -> fileReader.readFile(WRONG_PATH2));
    }

    @Test
    public void readEmptyFile_ok() {
        Assertions.assertEquals(0, fileReader.readFile(EMPTY_PATH).size());
    }

    @Test
    public void correctPathTest_ok() {
        Assertions.assertEquals(7, fileReader.readFile(CORRECT_PATH).size());
    }


}