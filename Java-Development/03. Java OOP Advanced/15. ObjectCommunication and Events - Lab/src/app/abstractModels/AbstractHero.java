package app.abstractModels;

import app.enums.LogType;
import app.interfaces.Attacker;
import app.interfaces.Observer;
import app.interfaces.Target;

public abstract class AbstractHero implements Observer, Attacker {

    private static final String TARGET_NULL_MESSAGE = "app.interfaces.Target null";
    private static final String NO_TARGET_MESSAGE = "%s has no target";
    private static final String TARGET_DEAD_MESSAGE = "%s is dead";
    private static final String SET_TARGET_MESSAGE = "%s targets %s";

    private String id;
    private int dmg;
    private Target target;
    private AbstractLogger logger;

    public AbstractHero(String id, int dmg, AbstractLogger logger) {
        this.id = id;
        this.dmg = dmg;
        this.logger = logger;
    }

    protected AbstractLogger getLogger() {
        return this.logger;
    }

    public void setTarget(Target target) {
        if (target == null) {
            logger.handle(LogType.ERROR, TARGET_NULL_MESSAGE);
        } else {
            this.target = target;
            logger.handle(LogType.EVENT, String.format(SET_TARGET_MESSAGE, this, target));
        }
    }

    public final void attack() {
        if (this.target == null) {
            logger.handle(LogType.ERROR, String.format(NO_TARGET_MESSAGE, this));
        } else if (this.target.isDead()) {
            logger.handle(LogType.ERROR, String.format(TARGET_DEAD_MESSAGE, target));
        } else {
            this.executeClassSpecificAttack(this.target, this.dmg);
        }
    }

    @Override
    public String toString() {
        return this.id;
    }

    protected abstract void executeClassSpecificAttack(Target target, int dmg);

    @Override
    public void update(int reward) {
        this.logger.handle(LogType.EVENT, String.format("%s gains %d xp", this, reward));
    }
}
