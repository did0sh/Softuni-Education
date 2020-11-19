package app.models.participants;

import app.contracts.Targetable;

public abstract class BaseTargetable implements Targetable {
    private String name;
    private double health;
    private double damage;
    private double gold;

    BaseTargetable(String name, double health, double damage, double gold) {
        this.name = name;
        this.setHealth(health);
        this.damage = damage;
        this.gold = gold;
    }

    BaseTargetable(double health, double damage, double gold) {
        this.setHealth(health);
        this.damage = damage;
        this.gold = gold;
    }

    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public void setHealth(double health){
        this.health = health;
    }

    @Override
    public boolean isAlive() {
        return this.getHealth() > 0;
    }

    @Override
    public void giveReward(Targetable targetable){
        targetable.receiveReward(this.getGold());
        this.gold = 0;
    }

    @Override
    public void receiveReward(double reward){
        this.gold += reward;
    }

    @Override
    public double getDamage(){
        return this.damage;
    }

    @Override
    public String attack(Targetable target){
        target.takeDamage(this.damage);

        return String.format("%s attacked!",target.getName());
    }

    @Override
    public abstract void levelUp();
}
