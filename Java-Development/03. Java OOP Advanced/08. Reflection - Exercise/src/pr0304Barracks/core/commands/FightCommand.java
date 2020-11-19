package pr0304Barracks.core.commands;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class FightCommand extends Command {

    @Inject
    private Repository repository;

    @Inject
    private UnitFactory factory;

    public FightCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return "fight";
    }
}
