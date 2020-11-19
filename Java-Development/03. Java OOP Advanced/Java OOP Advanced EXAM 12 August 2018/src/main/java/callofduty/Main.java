package callofduty;

import callofduty.commands.CommandManager;
import callofduty.engine.EngineImpl;
import callofduty.io.ConsoleReader;
import callofduty.io.ConsoleWriter;

public class Main {
    public static void main(String[] args)  {
        ConsoleWriter writer = new ConsoleWriter();
        ConsoleReader reader = new ConsoleReader();
        CommandManager manager = new CommandManager();
        EngineImpl engine = new EngineImpl(reader,writer,manager);

        engine.run();
    }
}




