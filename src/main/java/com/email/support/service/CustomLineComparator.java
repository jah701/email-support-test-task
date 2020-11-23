package com.email.support.service;

import com.email.support.model.Line;

public interface CustomLineComparator {
    boolean compareLines(Line line1, Line line2);

    boolean compareDate(Line queryLine, Line timeline);
}
