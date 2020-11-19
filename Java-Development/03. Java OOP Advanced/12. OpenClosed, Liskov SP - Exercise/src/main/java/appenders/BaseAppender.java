package appenders;

import interfaces.Appender;
import interfaces.Layout;
import models.ReportLevel;

public abstract class BaseAppender implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;
    private int messagesAppended;

    protected BaseAppender(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    protected Layout getLayout() {
        return this.layout;
    }

    protected ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    protected void increaseMessages(){
        this.messagesAppended++;
    }

    protected int getMessagesAppended() {
        return this.messagesAppended;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d%n",
                this.getClass().getSimpleName(), this.getLayout().getClass().getSimpleName(),
                this.getReportLevel().name(), this.getMessagesAppended()));
        return sb.toString();
    }
}
