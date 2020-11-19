package interfaces;

import models.Message;
import models.ReportLevel;

public interface Appender {
    void appendMessage(Message message);

    void setReportLevel(ReportLevel reportLevel);
}
