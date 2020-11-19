package cresla.interfaces;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface Manager {
    String reactorCommand(List<String> arguments);

    String moduleCommand(List<String> arguments) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException;

    String reportCommand(List<String> arguments);

    String exitCommand(List<String> arguments) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException;
}
