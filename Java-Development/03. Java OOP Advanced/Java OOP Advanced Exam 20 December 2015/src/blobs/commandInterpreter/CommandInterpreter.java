package blobs.commandInterpreter;

import blobs.annotations.Alias;
import blobs.annotations.Inject;
import blobs.factories.AttackFactory;
import blobs.factories.BehaviorFactory;
import blobs.interfaces.Executable;
import blobs.interfaces.OutputWriter;
import blobs.models.BlobRepository;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class CommandInterpreter {
    private static final String COMMANDS_LOCATION = "src/blobs/commandInterpreter/commands.";
    private static final String COMMANDS_PACKAGE = "blobs.commandInterpreter.commands.";
    private static final String COMMAND_SUFFIX = "Command";

    private OutputWriter writer;
    private AttackFactory attackFactory;
    private BehaviorFactory behaviorFactory;
    private BlobRepository repository;

    public CommandInterpreter(OutputWriter writer, AttackFactory attackFactory, BehaviorFactory behaviorFactory, BlobRepository repository) {
        this.writer = writer;
        this.attackFactory = attackFactory;
        this.behaviorFactory = behaviorFactory;
        this.repository = repository;
    }

    public void interpretCommand(String input) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String[] data = input.split(" ");
        String commandName = data[0].toLowerCase();

        Executable command = parseCommand(data, commandName);
        command.execute();
    }

    private Executable parseCommand(String[] data, String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        File file = new File(COMMANDS_LOCATION + commandName.toUpperCase().charAt(0) + commandName.toLowerCase().substring(1) + COMMAND_SUFFIX);
        Executable command = null;
        String className = null;

        if (commandName.equals("report-events")){
            className = file.getName().substring(file.getName().lastIndexOf('.') + 1)
            .replace("-", "");
        } else {
            className = file.getName().substring(file.getName().lastIndexOf('.') + 1);
        }

            Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMANDS_PACKAGE + className);

            Alias alias = commandClass.getAnnotation(Alias.class);
            String value = alias.value();

            Constructor<Executable> constructor = commandClass.getConstructor(String[].class);
            command = constructor.newInstance((Object) data);
            this.injectDependencies(command, commandClass);

        return command;
    }

    private void injectDependencies(Executable command, Class<Executable> commandClass) throws IllegalAccessException {
        Field[] clientFields = commandClass.getDeclaredFields();
        for (Field clientField : clientFields) {
            if (!clientField.isAnnotationPresent(Inject.class)) {
                continue;
            }
            clientField.setAccessible(true);

            Field[] serviceFields = CommandInterpreter.class.getDeclaredFields();
            for (Field serviceField : serviceFields) {
                if (!serviceField.getType().equals(clientField.getType())) {
                    continue;
                }
                serviceField.setAccessible(true);

                clientField.set(command, serviceField.get(this));
                break;
            }
        }
    }
}
