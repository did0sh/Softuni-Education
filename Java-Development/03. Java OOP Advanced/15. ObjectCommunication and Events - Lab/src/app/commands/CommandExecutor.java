package app.commands;

import app.interfaces.Command;
import app.interfaces.Executor;

public class CommandExecutor implements Executor {
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
