package com.mcqtest.common.util;

import com.mcqtest.common.event.BaseEvent;

import org.greenrobot.eventbus.EventBus;

public final class Bus {

    private Bus() {

    }

    public static void register(Object object) {
        EventBus.getDefault().register(object);
    }

    public static void unregister(Object object) {
        EventBus.getDefault().unregister(object);
    }

    private static void post(BaseEvent baseEvent) {
        EventBus.getDefault().post(baseEvent);
    }

    public static void postScoreOkClickEvent(String score) {
        post(new ScoreOkClickEvent(score));
    }
}
