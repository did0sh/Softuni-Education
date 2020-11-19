package app.commands;

import app.interfaces.AttackGroup;
import app.interfaces.Command;
import app.interfaces.Target;

public class GroupTargetCommand implements Command {
    private AttackGroup attackGroup;
    private Target target;

    public GroupTargetCommand(AttackGroup attackGroup, Target target) {
        this.attackGroup = attackGroup;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attackGroup.groupTarget(this.target);
    }
}
