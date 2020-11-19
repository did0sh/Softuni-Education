package app.commands;

import app.interfaces.Attacker;
import app.interfaces.Command;
import app.interfaces.Target;

public class TargetCommand implements Command {
    private Attacker attacker;
    private Target target;

    public TargetCommand(Attacker attacker, Target target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attacker.setTarget(this.target);
        this.target.receiveDamage(10);
        this.attacker.attack();
    }
}
