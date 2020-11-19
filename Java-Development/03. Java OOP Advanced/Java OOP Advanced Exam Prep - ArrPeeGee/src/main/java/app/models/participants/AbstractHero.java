package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

public abstract class AbstractHero extends BaseTargetable implements Hero {
    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;

    AbstractHero(double health, double damage, double gold, int strength, int dexterity, int intelligence) {
        super(health, damage, gold);
        this.setStrength(strength);
        this.setDexterity(dexterity);
        this.setIntelligence(intelligence);
        this.level = 1;
    }

    AbstractHero(String name, double health, double damage, double gold, int strength, int dexterity, int intelligence) {
        super(name,health, damage, gold);
        this.setStrength(strength);
        this.setDexterity(dexterity);
        this.setIntelligence(intelligence);
        this.level = 1;
    }


    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()){
            return target.getName() + " is dead! Cannot be attacked.";
        }

        target.takeDamage(this.getDamage());

        String result = this.getName() + " attacked!";
        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }

        return result;
    }

    @Override
    public abstract double getDamage();

    @Override
    public void levelUp() {
        this.setStrength(this.getStrength() * Config.LEVEL_UP_MULTIPLIER);
        this.setDexterity(this.getDexterity() * Config.LEVEL_UP_MULTIPLIER);
        this.setIntelligence(this.getIntelligence() * Config.LEVEL_UP_MULTIPLIER);
        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
        this.level += 1;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int getDexterity() {
        return this.dexterity;
    }

    @Override
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public int getIntelligence() {
        return this.intelligence;
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold", this.getStrength(), this.getDexterity(), this.getIntelligence(), this.getGold()));

        return sb.toString();
    }
}
