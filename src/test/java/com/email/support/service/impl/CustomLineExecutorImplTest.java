package com.email.support.service.impl;

import com.email.support.model.Line;
import com.email.support.service.CustomFileReader;
import com.email.support.service.CustomLineComparator;
import com.email.support.service.CustomLineExecutor;
import com.email.support.service.CustomLineParser;
import com.email.support.service.mapper.LineMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class CustomLineExecutorImplTest {
    private static final String CORRECT_PATH = "src/test/java/resources/file.txt";

    private static CustomLineComparator comparator;
    private static CustomLineExecutor executor;
    private static CustomLineParser parser;
    private static LineMapper mapper;
    private static CustomFileReader reader;

    @BeforeAll
    static void beforeAll() {
        comparator = new CustomLineComparatorImpl();
        reader = new CustomFileReaderImpl();
        mapper = new LineMapper();
        parser = new CustomLineParserImpl(mapper);
        executor = new CustomLineExecutorImpl(comparator);
    }

    @Test
    public void executeMethodTest_ok() {
        List<String> lines = reader.readFile(CORRECT_PATH);
        List<Line> parseLines = parser.parseLines(lines);
        String actual = executor.execute(parseLines);
        Assertions.assertEquals(7, actual.length());
    }
}