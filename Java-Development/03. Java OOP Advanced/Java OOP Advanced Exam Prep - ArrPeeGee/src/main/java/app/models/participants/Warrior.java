package app.models.participants;

import app.models.Config;

public class Warrior extends AbstractHero{

    public Warrior(String name) {
        super(name,Config.WARRIOR_BASE_STRENGTH * Config.HERO_HEALTH_MULTIPLIER,
                Config.WARRIOR_BASE_STRENGTH * 2 + Config.WARRIOR_BASE_DEXTERITY,
                Config.HERO_START_GOLD,
                Config.WARRIOR_BASE_STRENGTH,
                Config.WARRIOR_BASE_DEXTERITY,
                Config.WARRIOR_BASE_INTELLIGENCE);
    }

    public Warrior() {
        super(Config.WARRIOR_BASE_STRENGTH * Config.HERO_HEALTH_MULTIPLIER,
                Config.WARRIOR_BASE_STRENGTH * 2 + Config.WARRIOR_BASE_DEXTERITY,
                Config.HERO_START_GOLD,
                Config.WARRIOR_BASE_STRENGTH,
                Config.WARRIOR_BASE_DEXTERITY,
                Config.WARRIOR_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return (super.getStrength() * 2) + super.getDexterity();
    }


}
