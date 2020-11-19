package app.models.participants;

import app.models.Config;

public class Necromancer extends AbstractHero {
    public Necromancer(String name) {
        super(name,Config.NECROMANCER_BASE_STRENGTH * Config.HERO_HEALTH_MULTIPLIER,
                Config.NECROMANCER_BASE_INTELLIGENCE * 2 + Config.NECROMANCER_BASE_DEXTERITY * 2 +
                Config.NECROMANCER_BASE_STRENGTH * 2,
                Config.HERO_START_GOLD,
                Config.NECROMANCER_BASE_STRENGTH,
                Config.NECROMANCER_BASE_DEXTERITY,
                Config.NECROMANCER_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return (super.getIntelligence() * 2) + (super.getDexterity() * 2) + (super.getStrength() * 2);
    }
}
