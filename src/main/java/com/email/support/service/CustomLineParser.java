package com.email.support.service;

import com.email.support.model.Line;
import java.util.List;

public interface CustomLineParser {
    List<Line> parseLines(List<String> fileLines);
}
