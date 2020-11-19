package pr0304Barracks.core.commands;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class AddCommand extends Command {
    @Inject
    private Repository repository;

    @Inject
    private UnitFactory factory;

    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String unitType = super.getData()[1];
        Unit unitToAdd = this.factory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
