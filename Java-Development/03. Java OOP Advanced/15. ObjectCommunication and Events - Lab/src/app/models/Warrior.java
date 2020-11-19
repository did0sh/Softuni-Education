package app.models;

import app.abstractModels.AbstractLogger;
import app.abstractModels.AbstractHero;
import app.interfaces.Target;
import app.enums.LogType;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";

    public Warrior(String id, int dmg, AbstractLogger logger) {
        super(id, dmg, logger);
    }

    @Override
    protected void executeClassSpecificAttack(Target target, int dmg) {
        super.getLogger().handle(LogType.ATTACK, String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }
}
