package com.email.support.service.impl;

import com.email.support.model.Line;
import com.email.support.service.CustomFileReader;
import com.email.support.service.CustomLineParser;
import com.email.support.service.mapper.LineMapper;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CustomLineParserImplTest {
    private static final String CORRECT_PATH = "src/test/java/resources/file.txt";
    private static LineMapper mapper;
    private static CustomLineParser parser;
    private static CustomFileReader reader;

    @BeforeAll
    static void beforeAll() {
        mapper = new LineMapper();
        parser = new CustomLineParserImpl(mapper);
    }

    @Test
    public void wrongParseTest_ok() {
        List<String> actual = List.of("Q", "123", "asd");
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> parser.parseLines(actual));
    }

    @Test
    public void parseTest_ok() {
        reader = new CustomFileReaderImpl();
        List<String> lines = reader.readFile(CORRECT_PATH);
        List<Line> parsedLines = parser.parseLines(lines);
        Assertions.assertEquals(7, parsedLines.size());
    }
}
