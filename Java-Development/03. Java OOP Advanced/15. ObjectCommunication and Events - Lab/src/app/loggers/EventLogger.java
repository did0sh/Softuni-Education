package app.loggers;

import app.abstractModels.AbstractLogger;
import app.enums.LogType;

public class EventLogger extends AbstractLogger {
    @Override
    public void handle(LogType logType, String message) {
        if (logType == LogType.EVENT){
            System.out.println(logType.name() + ": " + message);
            return;
        }

        super.passToSuccessor(logType, message);
    }
}
