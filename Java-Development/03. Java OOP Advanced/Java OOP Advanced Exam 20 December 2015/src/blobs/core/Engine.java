package blobs.core;

import blobs.commandInterpreter.CommandInterpreter;
import blobs.factories.AttackFactory;
import blobs.factories.BehaviorFactory;
import blobs.interfaces.InputReader;
import blobs.io.ConsoleInputReader;
import blobs.io.ConsoleOutputWriter;
import blobs.models.BlobRepository;

import java.lang.reflect.InvocationTargetException;

public class Engine {
    private InputReader inputReader;
    private CommandInterpreter commandInterpreter;

    public Engine() {
        this.inputReader = new ConsoleInputReader();
        this.commandInterpreter = new CommandInterpreter(
                new ConsoleOutputWriter(),
                new AttackFactory(),
                new BehaviorFactory(),
                new BlobRepository());
    }

    public void run() {
        String command;

        while (!"drop".equals(command = this.inputReader.readLine())) {

            try {
                this.commandInterpreter.interpretCommand(command);
            } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
                e.printStackTrace();
            }

        }
    }
}
