package pr0304Barracks.core.factories;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.CommandInterpreter;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.core.Injector;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMANDS_PACKAGE_NAME =
            "pr0304Barracks.core.commands.";
    private static final String COMMAND_SUFFIX = "Command";
    private static final String COMMANDS_LOCATION = "src/pr0304Barracks/core/commands";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        Executable command = null;

        String commandType = commandName.toUpperCase().charAt(0) + commandName.substring(1) + COMMAND_SUFFIX;

        try {
            Class commandClass = Class.forName(COMMANDS_PACKAGE_NAME + commandType);
            Constructor[] constructor = commandClass.getDeclaredConstructors();

            for (Constructor constructor1 : constructor) {
                if (constructor1.getParameterCount() == 1){
                    command = (Executable) constructor1.newInstance((Object)data);
                    Injector.injectDependencies(command, this);
                    break;
                }
            }
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return command;
    }

    private void injectDependencies(Executable executable, Class<Executable> executableClass) throws ReflectiveOperationException {
        Field[] clientFields = executableClass.getDeclaredFields();
        for (Field clientField : clientFields) {
            if (!clientField.isAnnotationPresent(Inject.class)) {
                continue;
            }
            clientField.setAccessible(true);

            Field[] serviceFields = CommandInterpreterImpl.class.getDeclaredFields();
            for (Field serviceField : serviceFields) {
                if (!serviceField.getType().equals(clientField.getType())) {
                    continue;
                }
                serviceField.setAccessible(true);
                clientField.set(executable, serviceField.get(this));
            }
        }
    }
}
