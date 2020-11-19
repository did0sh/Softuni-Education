package layouts;

import interfaces.Layout;
import models.Message;

public class SimpleLayout implements Layout {
    @Override
    public String formatMessage(Message message) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %s - %s%n", message.getDate(), message.getReportLevel().name(), message.getMessage()));
        return sb.toString();
    }
}
