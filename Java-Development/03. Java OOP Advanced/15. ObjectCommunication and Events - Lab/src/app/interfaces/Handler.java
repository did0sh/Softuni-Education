package app.interfaces;

import app.enums.LogType;

public interface Handler {
    void handle(LogType logType, String message);
    void setSuccessor(Handler handler);
}
