package appenders;

import interfaces.Layout;
import models.Message;

public class ConsoleAppender extends BaseAppender {
    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void appendMessage(Message message) {
        if (message.getReportLevel().ordinal() < super.getReportLevel().ordinal()){
            return;
        }
        System.out.print(super.getLayout().formatMessage(message));
        super.increaseMessages();
    }
}
