package pr0304Barracks.core.commands;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class RetireCommand extends Command {
    @Inject
    private Repository repository;

    @Inject
    private UnitFactory factory;

    public RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String unitType = this.getData()[1];
        try {
            this.repository.removeUnit(unitType);
        }catch (IllegalArgumentException ex){
            return ex.getMessage();
        }

        String output = unitType + " retired!";
        return output;
    }
}
