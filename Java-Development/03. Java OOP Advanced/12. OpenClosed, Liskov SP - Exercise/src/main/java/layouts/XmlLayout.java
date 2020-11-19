package layouts;

import interfaces.Layout;
import models.Message;

public class XmlLayout implements Layout {

    @Override
    public String formatMessage(Message message) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("<log>%n   <date>%s</date>%n   <level>%s</level>%n   <message>%s</message>%n</log>%n",
                message.getDate(), message.getReportLevel(), message.getMessage()));
        return sb.toString();
    }
}
