package com.email.support.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.email.support.model.Line;
import com.email.support.model.QueryLine;
import com.email.support.model.WaitingTimeline;
import com.email.support.service.CustomLineComparator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CustomLineComparatorImplTest {
    private static CustomLineComparator comparator;

    @BeforeAll
    static void beforeAll() {
        comparator = new CustomLineComparatorImpl();
    }

    @Test
    public void compareTwoLines_ok() {
        Line queryLine = new QueryLine();
        queryLine.setServiceId("1.1");
        queryLine.setQuestionType("2.3");
        queryLine.setResponseType("P");
        queryLine.setDate("12.09.2000-15.09.2000");

        Line timeline = new WaitingTimeline();
        timeline.setServiceId("1.4");
        timeline.setQuestionType("2.9");
        timeline.setResponseType("P");
        timeline.setDate("14.09.2000");

        Line queryLine2 = new QueryLine();
        queryLine2.setServiceId("4.1");
        queryLine2.setQuestionType("2.3");
        queryLine2.setResponseType("P");
        queryLine2.setDate("12.09.2000-15.09.2000");

        Line timeline2 = new WaitingTimeline();
        timeline2.setServiceId("1.4");
        timeline2.setQuestionType("2.9");
        timeline2.setResponseType("P");
        timeline2.setDate("14.09.2000");

        Line queryLine3 = new QueryLine();
        queryLine3.setServiceId("1.1");
        queryLine3.setQuestionType("*");
        queryLine3.setResponseType("P");
        queryLine3.setDate("22.09.2000");

        Line timeline3 = new WaitingTimeline();
        timeline3.setServiceId("1.4");
        timeline3.setQuestionType("2.3");
        timeline3.setResponseType("N");
        timeline3.setDate("22.09.2000");

        Line queryLine4 = new QueryLine();
        queryLine4.setServiceId("1.1");
        queryLine4.setQuestionType("*");
        queryLine4.setResponseType("P");
        queryLine4.setDate("22.09.2000");

        Line timeline4 = new WaitingTimeline();
        timeline4.setServiceId("1.4");
        timeline4.setQuestionType("6.9.1");
        timeline4.setResponseType("P");
        timeline4.setDate("22.09.2000");

        assertTrue(comparator.compareLines(queryLine, timeline));
        assertFalse(comparator.compareLines(queryLine2, timeline2));
        assertFalse(comparator.compareLines(queryLine3, timeline3));
        assertTrue(comparator.compareLines(queryLine4, timeline4));
    }
}
