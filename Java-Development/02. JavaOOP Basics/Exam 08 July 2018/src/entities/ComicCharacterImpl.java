package entities;

import contracts.ComicCharacter;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ComicCharacterImpl implements ComicCharacter {
    private String name;
    private int energy;
    private double health;
    private double intelligence;
    private Map<String,Power> powers;


    public ComicCharacterImpl(String name, int energy, double health, double intelligence) {
        this.setName(name);
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
        this.powers = new LinkedHashMap<>();
    }

    private void setName(String name) {
        Pattern pattern = Pattern.compile("^[A-Za-z_]{2,12}$");
        Matcher matcher = pattern.matcher(name);
        if (matcher.find()){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Comic Character name is not in the correct format!");
        }

    }

    private void setEnergy(int energy) {
        if (energy >= 0 && energy <= 300){
            this.energy = energy;
        } else {
            throw new IllegalArgumentException("Energy is not in the correct range!");
        }

    }

    private void setHealth(double health) {
        if (health >= 0){
            this.health = health;
        } else {

            throw new IllegalArgumentException("Health should be a positive number!");
        }

    }

    private void setIntelligence(double intelligence) {
        if (intelligence >= 0 && intelligence <= 200){
            this.intelligence = intelligence;
        } else {
            throw new IllegalArgumentException("Intelligence is not in the correct range!");
        }

    }

    public Map<String,Power> getPowers() {
        return Collections.unmodifiableMap(this.powers);
    }

    @Override
    public void takeDamage(double damage) {
        double newHealth = this.health - damage;
        this.setHealth(newHealth);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void boostCharacter(int energy, double health, double intelligence) {
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public double getIntelligence() {
        return this.intelligence;
    }

    @Override
    public String useSuperPowers() {
        StringBuilder sb = new StringBuilder();
        if (this.getPowers().size() == 0){
            sb.append(String.format("%s has no super powers!%n", this.getName()));
        }

        int currentEnergy = this.getEnergy();
        double currentHealth = this.getHealth();

        for (Power power : powers.values()) {
            currentEnergy += power.getPowerPoints();
            currentHealth +=  power.getPowerPoints() * 2;
        }

        sb.append(String.format("%s used his super powers!%n", this.getName()));
        return sb.toString();

    }

    @Override
    public void addSuperPower(Power power) {
        this.powers.put(power.getName(),power);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("#Name: %s%n", this.getName()))
                .append(String.format("##Health: %.2f// Energy: %d// Intelligence: %.2f%n"
                ,this.getHealth(), this.getEnergy(), this.getIntelligence()));

        return sb.toString();
    }
}
