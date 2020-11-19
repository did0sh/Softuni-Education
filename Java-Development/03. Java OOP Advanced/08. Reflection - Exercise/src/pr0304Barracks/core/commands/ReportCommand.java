package pr0304Barracks.core.commands;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class ReportCommand extends Command {
    @Inject
    private Repository repository;

    @Inject
    private UnitFactory factory;

    public ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String output = this.repository.getStatistics();
        return output;
    }
}
