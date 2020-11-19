package app.abstractModels;

import app.enums.LogType;
import app.interfaces.Handler;

public abstract class AbstractLogger implements Handler {

    private Handler successor;

    @Override
    public void setSuccessor(Handler handler) {
        this.successor = handler;
    }

    protected void passToSuccessor(LogType logType, String message){
        if (this.successor != null){
            this.successor.handle(logType, message);
        }

    }

    @Override
    public abstract void handle(LogType logType, String message);
}
