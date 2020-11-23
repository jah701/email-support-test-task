package com.email.support.service.impl;

import com.email.support.model.Line;
import com.email.support.service.CustomLineComparator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomLineComparatorImpl implements CustomLineComparator {
    private static final int ZERO_INDEX = 0;
    private static final int MAX_DATE_STRING_SIZE = 10;
    private static final String DASH_DELIMITER = "-";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public boolean compareLines(Line queryLine, Line timeline) {
        if (!queryLine.getServiceId().split("")[ZERO_INDEX]
                .equals(timeline.getServiceId().split("")[ZERO_INDEX])) {
            return false;
        }
        if (!timeline.getQuestionType().equals("*")
                && !queryLine.getQuestionType().split("")[ZERO_INDEX]
                .equals(timeline.getQuestionType().split("")[ZERO_INDEX])) {
            return false;
        }
        if (!queryLine.getResponseType().split("")[ZERO_INDEX]
                .equals(timeline.getResponseType().split("")[ZERO_INDEX])) {
            return false;
        }
        if (queryLine.getDate().length() > MAX_DATE_STRING_SIZE) {
            return compareDate(queryLine, timeline);
        } else if (timeline.getDate().length() > MAX_DATE_STRING_SIZE) {
            return compareDate(timeline, queryLine);
        } else {
            return LocalDate.parse(queryLine.getDate(), FORMATTER)
                    .compareTo(LocalDate.parse(timeline.getDate(), FORMATTER)) == 0;
        }
    }

    public boolean compareDate(Line queryLine, Line timeline) {
        String[] splitDate = queryLine.getDate().split(DASH_DELIMITER);
        LocalDate dateFrom = LocalDate.parse(splitDate[0], FORMATTER);
        LocalDate dateTo = LocalDate.parse(splitDate[1], FORMATTER);
        LocalDate dateToCompare = LocalDate.parse(timeline.getDate(), FORMATTER);
        return dateToCompare.isAfter(dateFrom)
                && dateToCompare.isBefore(dateTo);
    }
}
