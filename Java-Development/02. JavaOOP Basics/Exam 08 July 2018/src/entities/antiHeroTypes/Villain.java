package entities.antiHeroTypes;

import contracts.ComicCharacter;
import entities.AntiHero;

public class Villain extends AntiHero implements ComicCharacter {
    public Villain(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        return (super.getIntelligence() * super.getSpecial()) / super.getEnergy();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("####Villain Attack Power: %.2f%n", this.attack()));
        return sb.toString();
    }
}
