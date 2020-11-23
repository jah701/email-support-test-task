package com.email.support.service.impl;

import com.email.support.model.Line;
import com.email.support.service.CustomLineParser;
import com.email.support.service.mapper.LineMapper;
import java.util.List;
import java.util.stream.Collectors;

public class CustomLineParserImpl implements CustomLineParser {
    private final LineMapper lineMapper;

    public CustomLineParserImpl(LineMapper lineMapper) {
        this.lineMapper = lineMapper;
    }

    @Override
    public List<Line> parseLines(List<String> fileLines) {
        return fileLines.stream()
                .map(lineMapper::map)
                .collect(Collectors.toList());
    }
}
