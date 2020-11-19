package appenders;

import interfaces.File;
import interfaces.Layout;
import models.LogFile;
import models.Message;

public class FileAppender extends BaseAppender {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    @Override
    public void appendMessage(Message message) {
        if (message.getReportLevel().ordinal() < super.getReportLevel().ordinal()) {
            return;
        }
        this.file.write(super.getLayout().formatMessage(message));
        super.increaseMessages();
    }

    public void setFile(File file){
        this.file = file;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
       sb.append(String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d, File size: %d%n",
                this.getClass().getSimpleName(), this.getLayout().getClass().getSimpleName(),
                this.getReportLevel().name(), this.getMessagesAppended(), this.file.getSize()));
        return sb.toString();
    }
}
