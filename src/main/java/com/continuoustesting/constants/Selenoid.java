package com.continuoustesting.constants;

public enum Selenoid {

    BROWSER("browserName"), VERSION("browserVersion"), VNC("enableVNC"), VIDEO("enableVideo"), VIDEO_NAME("videoName"),
    LOG("enableLog"), LOG_NAME("logName");

    public final String label;

    private Selenoid(String label) {
        this.label = label;
    }
}