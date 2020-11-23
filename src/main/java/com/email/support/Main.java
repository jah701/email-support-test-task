package com.email.support;

import com.email.support.model.Line;
import com.email.support.service.CustomFileReader;
import com.email.support.service.CustomLineComparator;
import com.email.support.service.CustomLineExecutor;
import com.email.support.service.CustomLineParser;
import com.email.support.service.PropertiesService;
import com.email.support.service.impl.CustomFileReaderImpl;
import com.email.support.service.impl.CustomLineComparatorImpl;
import com.email.support.service.impl.CustomLineExecutorImpl;
import com.email.support.service.impl.CustomLineParserImpl;
import com.email.support.service.impl.PropertiesServiceImpl;
import com.email.support.service.mapper.LineMapper;
import java.util.List;

public class Main {
    private static final String PROP_NAME = "file.path";

    public static void main(String[] args) {
        PropertiesService propertiesService = new PropertiesServiceImpl();
        LineMapper mapper = new LineMapper();
        CustomFileReader reader = new CustomFileReaderImpl();
        CustomLineParser parser = new CustomLineParserImpl(mapper);
        List<Line> parsedLines
                = parser.parseLines(reader.readFile(propertiesService.getProperty(PROP_NAME)));
        CustomLineComparator comparator = new CustomLineComparatorImpl();
        CustomLineExecutor executor = new CustomLineExecutorImpl(comparator);
        System.out.println(executor.execute(parsedLines));
    }
}
