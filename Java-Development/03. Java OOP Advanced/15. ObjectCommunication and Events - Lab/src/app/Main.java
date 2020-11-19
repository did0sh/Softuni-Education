package app;

import app.commands.*;
import app.interfaces.*;
import app.abstractModels.AbstractLogger;
import app.loggers.CombatLogger;
import app.loggers.ErrorLogger;
import app.abstractModels.AbstractHero;
import app.enums.LogType;
import app.loggers.EventLogger;
import app.models.Dragon;
import app.models.Group;
import app.models.Warrior;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        AbstractLogger combatLog = new CombatLogger();
        AbstractLogger eventLog = new EventLogger();

        combatLog.setSuccessor(eventLog);

        AttackGroup group = new Group();
        Attacker warrior = new Warrior("warrior", 10, combatLog);
        Target dragon = new Dragon("dragon", 100, 25, combatLog);

        group.addMember(warrior);
        group.addMember(warrior);

        Executor executor = new CommandExecutor();

        Command target = new GroupTargetCommand(group, dragon);
        Command attack = new GroupAttackCommand(group);

        executor.executeCommand(target);
        executor.executeCommand(attack);
    }
}
