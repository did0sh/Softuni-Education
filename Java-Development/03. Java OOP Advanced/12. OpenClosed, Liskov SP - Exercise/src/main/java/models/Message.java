package models;

public class Message {
    private String date;
    private String message;
    private ReportLevel reportLevel;

    public Message(String date, String message, ReportLevel reportLevel) {
        this.date = date;
        this.message = message;
        this.reportLevel = reportLevel;
    }

    public String getDate() {
        return this.date;
    }

    public String getMessage() {
        return this.message;
    }

    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }
}
