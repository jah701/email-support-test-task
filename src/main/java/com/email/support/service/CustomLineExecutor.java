package com.email.support.service;

import com.email.support.model.Line;
import java.util.List;

public interface CustomLineExecutor {
    String execute(List<Line> lines);
}
