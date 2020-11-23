package com.email.support.service.impl;

import com.email.support.model.Line;
import com.email.support.model.QueryLine;
import com.email.support.model.WaitingTimeline;
import com.email.support.service.CustomLineComparator;
import com.email.support.service.CustomLineExecutor;
import java.util.List;

public class CustomLineExecutorImpl implements CustomLineExecutor {
    private final CustomLineComparator comparator;

    public CustomLineExecutorImpl(CustomLineComparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public String execute(List<Line> lines) {
        StringBuilder sb = new StringBuilder();
        for (int queryLineIndex = 0; queryLineIndex < lines.size(); queryLineIndex++) {
            if (lines.get(queryLineIndex).getClass().equals(QueryLine.class)) {
                int minutes = 0;
                int counter = 0;
                for (int timelineIndex = 0; timelineIndex < queryLineIndex; timelineIndex++) {
                    if (lines.get(timelineIndex).getClass().equals(WaitingTimeline.class)
                            && comparator.compareLines(lines.get(queryLineIndex),
                            lines.get(timelineIndex))) {
                        WaitingTimeline timeline = (WaitingTimeline) lines.get(timelineIndex);
                        minutes += timeline.getWaitingTime();
                        counter += 1;
                    }
                }
                if (counter == 0) {
                    sb.append("-")
                            .append("\n");
                } else {
                    sb.append(minutes / counter)
                            .append("\n");
                }
            }
        }
        return sb.toString();
    }
}
