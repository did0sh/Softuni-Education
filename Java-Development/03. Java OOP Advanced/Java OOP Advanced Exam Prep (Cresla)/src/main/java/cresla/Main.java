package cresla;

import cresla.commandManager.CommandManager;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException, InstantiationException, ClassNotFoundException {
        CommandManager manager = new CommandManager();
        manager.run();
    }
}
