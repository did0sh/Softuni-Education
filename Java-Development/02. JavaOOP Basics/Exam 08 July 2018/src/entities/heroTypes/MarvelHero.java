package entities.heroTypes;

import contracts.ComicCharacter;
import entities.Hero;

public class MarvelHero extends Hero implements ComicCharacter {
    public MarvelHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }

    @Override
    public double attack() {
        return ((super.getEnergy() + super.getSpecial()) * super.getIntelligence()) / 2.5;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("####Marvel Attack Power: %.2f%n", this.attack()));
        return sb.toString();
    }
}
