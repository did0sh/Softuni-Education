package contracts;

import entities.AntiHero;
import entities.Hero;

public interface Arena {
    String getArenaName();

    boolean isArenaFull();

    void addHero(Hero hero);

    void addAntiHero(AntiHero antiHero);

    boolean fightHeroes();
}
