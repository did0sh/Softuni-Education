package models;

import interfaces.Appender;
import interfaces.Logger;

import java.util.Arrays;
import java.util.List;

public class MessageLogger implements Logger {
    private List<Appender> appenders;

    public MessageLogger(Appender... appenders) {
        this.setAppenders(appenders);
    }

    @Override
    public void logInfo(String date, String message) {
        Message msg = new Message(date, message, ReportLevel.INFO);
        for (Appender appender : this.appenders) {
            appender.appendMessage(msg);
        }
    }

    @Override
    public void logWarning(String date, String message) {
        Message msg = new Message(date, message, ReportLevel.WARNING);
        for (Appender appender : this.appenders) {
            appender.appendMessage(msg);
        }
    }

    @Override
    public void logError(String date, String message) {
        Message msg = new Message(date, message, ReportLevel.ERROR);
        for (Appender appender : this.appenders) {
            appender.appendMessage(msg);
        }
    }

    @Override
    public void logCritical(String date, String message) {
        Message msg = new Message(date, message, ReportLevel.CRITICAL);
        for (Appender appender : this.appenders) {
            appender.appendMessage(msg);
        }
    }

    @Override
    public void logFatal(String date, String message) {
        Message msg = new Message(date, message, ReportLevel.FATAL);
        for (Appender appender : this.appenders) {
            appender.appendMessage(msg);
        }
    }

    public void setAppenders(Appender[] appenders) {
        if (appenders.length <= 0){
            throw new IllegalArgumentException("MessageLogger must have at least 1 parameter");
        }
        this.appenders = Arrays.asList(appenders);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Logger info").append(System.lineSeparator());
        for (Appender appender : this.appenders) {
            sb.append(appender);
        }
        return sb.toString();
    }
}
