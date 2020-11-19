package entities;

import contracts.ComicCharacter;

public abstract class Hero extends ComicCharacterImpl implements ComicCharacter {
    private double heroism;
    public Hero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence);
        this.setHeroism(heroism);
    }

    private void setHeroism(double heroism) {
        if (heroism >= 0){
            this.heroism = heroism;
        } else {
            throw new IllegalArgumentException("Heroism should be a positive number!");
        }

    }

    @Override
    public double getSpecial() {
        return this.heroism;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("###Heroism: %.2f%n", this.getSpecial()));
        return sb.toString();
    }
}
