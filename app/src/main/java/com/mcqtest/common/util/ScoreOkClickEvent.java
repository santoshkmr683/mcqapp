package com.mcqtest.common.util;

import com.mcqtest.common.event.BaseEvent;

public class ScoreOkClickEvent extends BaseEvent {

    private String score;

    public ScoreOkClickEvent(String score) {
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
