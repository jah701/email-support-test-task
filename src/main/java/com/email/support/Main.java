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
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "app.properties";

        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            throw new RuntimeException("Can't load properties from : " + appConfigPath, e);
        }

        LineMapper mapper = new LineMapper();
        CustomFileReader reader = new CustomFileReaderImpl();
        CustomLineParser parser = new CustomLineParserImpl(mapper);
        List<Line> parsedLines
                = parser.parseLines(reader.readFile(appProps.getProperty("file.path")));
        CustomLineComparator comparator = new CustomLineComparatorImpl();
        CustomLineExecutor executor = new CustomLineExecutorImpl(comparator);
        System.out.println(executor.execute(parsedLines));
    }
}
