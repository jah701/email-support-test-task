package com.email.support.service.mapper;

import com.email.support.model.Line;
import com.email.support.model.QueryLine;
import com.email.support.model.WaitingTimeline;

public class LineMapper {
    private static final String SPACE_DELIMITER = " ";
    private static final String WAITING_TIMELINE_DEF_CHAR_INDEX = "C";
    private static final int DEF_CHAR_INDEX = 0;
    private static final int SERVICE_ID_INDEX = 1;
    private static final int QUESTION_TYPE_INDEX = 2;
    private static final int RESPONSE_TYPE_INDEX = 3;
    private static final int DATE_INDEX = 4;
    private static final int WAITING_TIME_INDEX = 5;

    public Line map(String line) {
        String[] split = line.split(" ");
        if (line.split(SPACE_DELIMITER)[DEF_CHAR_INDEX]
                .equals(WAITING_TIMELINE_DEF_CHAR_INDEX)) {
            WaitingTimeline timeline = new WaitingTimeline();
            timeline.setServiceId(split[SERVICE_ID_INDEX]);
            timeline.setQuestionType(split[QUESTION_TYPE_INDEX]);
            timeline.setResponseType(split[RESPONSE_TYPE_INDEX]);
            timeline.setDate(split[DATE_INDEX]);
            timeline.setWaitingTime(Integer.parseInt(split[WAITING_TIME_INDEX]));
            return timeline;
        } else {
            QueryLine queryLine = new QueryLine();
            queryLine.setServiceId(split[SERVICE_ID_INDEX]);
            queryLine.setQuestionType(split[QUESTION_TYPE_INDEX]);
            queryLine.setResponseType(split[RESPONSE_TYPE_INDEX]);
            queryLine.setDate(split[DATE_INDEX]);
            return queryLine;
        }
    }
}
