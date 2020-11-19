package app.commands;

import app.abstractModels.AbstractLogger;
import app.interfaces.Attacker;
import app.interfaces.Command;
import app.interfaces.Target;
import app.loggers.ErrorLogger;
import app.models.Dragon;

public class AttackCommand implements Command {
    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        AbstractLogger errorLogger = new ErrorLogger();
        Target dragon = new Dragon("dragon", 9, 15, errorLogger);
        this.attacker.setTarget(dragon);
        this.attacker.attack();
    }
}
