package app.models.participants;

import app.models.Config;

public class Wizard extends AbstractHero {
    public Wizard(String name) {
        super(name,Config.WIZARD_BASE_STRENGTH * Config.HERO_HEALTH_MULTIPLIER,
                Config.WIZARD_BASE_INTELLIGENCE * 5 + Config.WIZARD_BASE_DEXTERITY,
                Config.HERO_START_GOLD,
                Config.WIZARD_BASE_STRENGTH,
                Config.WIZARD_BASE_DEXTERITY,
                Config.WIZARD_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return (super.getIntelligence() * 5) + super.getDexterity();
    }
}
