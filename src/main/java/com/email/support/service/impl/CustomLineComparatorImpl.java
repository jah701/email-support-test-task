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

    public boolean compareLines(Line line1, Line line2) {
        if (!line1.getServiceId().split("")[ZERO_INDEX]
                .equals(line2.getServiceId().split("")[ZERO_INDEX])) {
            return false;
        }
        if (!line1.getQuestionType().equals("*") && !line1.getQuestionType().split("")[ZERO_INDEX]
                .equals(line2.getQuestionType().split("")[ZERO_INDEX])) {
            return false;
        }
        if (!line1.getResponseType().split("")[ZERO_INDEX]
                .equals(line2.getResponseType().split("")[ZERO_INDEX])) {
            return false;
        }
        if (line1.getDate().length() > MAX_DATE_STRING_SIZE) {
            return compareDate(line1, line2);
        } else if (line2.getDate().length() > MAX_DATE_STRING_SIZE) {
            return compareDate(line2, line1);
        } else {
            return LocalDate.parse(line1.getDate(), FORMATTER)
                    .compareTo(LocalDate.parse(line2.getDate(), FORMATTER)) == 0;
        }
    }

    public boolean compareDate(Line queryLine, Line timeline) {
        String[] splitDate = queryLine.getDate().split(DASH_DELIMITER);
        LocalDate dateFrom = LocalDate.parse(splitDate[0], FORMATTER);
        LocalDate dateTo = LocalDate.parse(splitDate[1], FORMATTER);
        LocalDate dateToCompare = LocalDate.parse(timeline.getDate(), FORMATTER);
        return dateToCompare.minusDays(1L).isAfter(dateFrom)
                && dateToCompare.plusDays(1L).isBefore(dateTo);
    }
}
