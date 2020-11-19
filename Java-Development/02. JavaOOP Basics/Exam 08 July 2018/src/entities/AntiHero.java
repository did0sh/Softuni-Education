package entities;

import contracts.ComicCharacter;

public abstract class AntiHero extends ComicCharacterImpl implements ComicCharacter {
    private double evilness;
    public AntiHero(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence);
        this.setEvilness(evilness);
    }

    private void setEvilness(double evilness) {
        if (evilness >= 0){
            this.evilness = evilness;
        } else {

            throw new IllegalArgumentException("Evilness should be a positive number!");
        }

    }

    @Override
    public double getSpecial() {
        return this.evilness;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("###Evilness: %.2f%n", this.getSpecial()));
        return sb.toString();
    }
}
