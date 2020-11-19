package contracts;

import entities.AntiHero;
import entities.ArenaImpl;
import entities.Hero;
import entities.Power;

public interface Manager {
    String checkComicCharacter(String characterName);

    String addHero(Hero hero);

    String addAntiHero(AntiHero antiHero);

    String addArena(ArenaImpl arena);

    String addHeroToArena(String arena, String hero);

    String addAntiHeroToArena(String arena, String antiHero);

    String loadSuperPowerToPool(Power power);

    String assignSuperPowerToComicCharacter(String comicCharacter, String power);

    String usePowers(String characterName);

    String startBattle(String arena);

    String endWar();
}
