package app.loggers;


import app.abstractModels.AbstractLogger;
import app.enums.LogType;

public class CombatLogger extends AbstractLogger {

    @Override
    public void handle(LogType logType, String message) {
        if (logType == LogType.ATTACK || logType == LogType.MAGIC){
            System.out.println(logType.name() + ": " + message);
            return;
        }

        super.passToSuccessor(logType, message);
    }
}
