package com.email.support;

import com.email.support.model.Line;
import com.email.support.service.CustomFileReader;
import com.email.support.service.CustomLineComparator;
import com.email.support.service.CustomLineExecutor;
import com.email.support.service.CustomLineParser;
import com.email.support.service.impl.CustomFileReaderImpl;
import com.email.support.service.impl.CustomLineComparatorImpl;
import com.email.support.service.impl.CustomLineExecutorImpl;
import com.email.support.service.impl.CustomLineParserImpl;
import com.email.support.service.mapper.LineMapper;
import java.util.List;

public class Main {
    private static final String FILE_PATH = "src/main/resources/file.txt";

    public static void main(String[] args) {
        LineMapper mapper = new LineMapper();
        CustomFileReader reader = new CustomFileReaderImpl();
        CustomLineParser parser = new CustomLineParserImpl(mapper);
        List<Line> parsedLines = parser.parseLines(reader.readFile(FILE_PATH));
        CustomLineComparator comparator = new CustomLineComparatorImpl();
        CustomLineExecutor executor = new CustomLineExecutorImpl(comparator);
        System.out.println(executor.execute(parsedLines));
    }
}
