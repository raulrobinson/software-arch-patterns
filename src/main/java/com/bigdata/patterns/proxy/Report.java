package com.bigdata.patterns.proxy;

public class Report {
    private final String content;

    public Report(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
