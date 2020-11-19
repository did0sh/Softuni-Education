package manager;

import contracts.Arena;
import contracts.Manager;
import entities.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class WarManager implements Manager {
    private int countHeroesWins;
    private int countAntiHeroesWins;

    private Map<String, ComicCharacterImpl> comicCharacters;
    private Map<String, ArenaImpl> arenas;
    private Map<String, Power> superPowers;

    public WarManager() {
        this.comicCharacters = new LinkedHashMap<>();
        this.arenas = new LinkedHashMap<>();
        this.superPowers = new LinkedHashMap<>();
    }

    @Override
    public String checkComicCharacter(String characterName) {
        if (!this.comicCharacters.containsKey(characterName)){
            return String.format("Sorry fans! %s doesn't exist in our comics!%n", characterName);
        }

        if (this.comicCharacters.get(characterName).getHealth() <= 0){
            return String.format("%s has fallen in battle!%n", characterName);
        }

        return this.comicCharacters.get(characterName).toString();
    }

    @Override
    public String addHero(Hero hero) {
        if (this.comicCharacters.containsKey(hero.getName())){
            try {
                hero.boostCharacter(hero.getEnergy(), hero.getHealth(), hero.getIntelligence());
                return String.format("%s evolved!%n", hero.getName());
            }catch (IllegalArgumentException iae){
                return iae.getMessage();
            }
        }

        this.comicCharacters.put(hero.getName(), hero);
        return String.format("%s is ready for battle!%n", hero.getName());
    }

    @Override
    public String addAntiHero(AntiHero antiHero) {
        if (this.comicCharacters.containsKey(antiHero.getName())){
            try {
                antiHero.boostCharacter(antiHero.getEnergy(), antiHero.getHealth(), antiHero.getIntelligence());
                return String.format("%s is getting stronger!%n", antiHero.getName());
            }catch (IllegalArgumentException iae){
                return iae.getMessage();
            }
        } else {
            this.comicCharacters.put(antiHero.getName(), antiHero);
            return String.format("%s is ready for destruction!%n", antiHero.getName());
        }
    }

    @Override
    public String addArena(ArenaImpl arena) {
        if (this.arenas.containsKey(arena.getArenaName())){
            return String.format("A battle is about to start there!%n");
        }

        this.arenas.put(arena.getArenaName(), arena);
        return String.format("%s is becoming a fighting ground!%n", arena.getArenaName());
    }

    @Override
    public String addHeroToArena(String arena, String hero) {
        if (this.arenas.get(arena).getHeroes().containsKey(hero)){
            return String.format("%s is fighting!%n", hero);
        }

        if (this.arenas.get(arena).isArenaFull()){
            return String.format("Arena is full!%n");
        }

        Hero hero1 = (Hero) this.comicCharacters.get(hero);
        this.arenas.get(arena).addHero(hero1);

        if (this.arenas.get(arena).getHeroes().get(hero).getHealth() <= 0){
            return String.format("%s is dead!%n", hero);
        }


        return String.format("%s is fighting for your freedom in %s!%n", hero, arena);
    }

    @Override
    public String addAntiHeroToArena(String arena, String antiHero) {
        if (this.arenas.get(arena).getAntiHeroes().containsKey(antiHero)){
            return String.format("%s is fighting!%n", antiHero);
        }

        if (this.arenas.get(arena).isArenaFull()){
            return String.format("Arena is full!%n");
        }

        AntiHero antiHero1 = (AntiHero) this.comicCharacters.get(antiHero);
        this.arenas.get(arena).addAntiHero(antiHero1);

        if (this.arenas.get(arena).getAntiHeroes().get(antiHero).getHealth() <= 0){
            return String.format("%s is dead!%n", antiHero);
        }


        return String.format("%s and his colleagues are trying to take over %s!%n", antiHero, arena);
    }

    @Override
    public String loadSuperPowerToPool(Power power) {
        if (this.superPowers.containsKey(power.getName())){
            return String.format("This super power already exists!%n");
        }

        this.superPowers.put(power.getName(), power);
        return String.format("%s added to pool!%n", power.getName());
    }

    @Override
    public String assignSuperPowerToComicCharacter(String comicCharacter, String power) {
        if (this.comicCharacters.get(comicCharacter).getPowers().containsKey(power)){
            return String.format("%s already assigned!%n", power);
        }

        Power power1 = this.superPowers.get(power);
        if (this.comicCharacters.containsKey(comicCharacter)){
            this.comicCharacters.get(comicCharacter).addSuperPower(power1);
        }

        return String.format("%s has a new super power!%n", comicCharacter);
    }

    @Override
    public String usePowers(String characterName) {
        return this.comicCharacters.get(characterName).useSuperPowers();
    }

    @Override
    public String startBattle(String arena) {
        if (this.arenas.get(arena).getParticipants() == 0){
            this.arenas.remove(arena);
            return String.format("SAFE ZONE!%n");
        }

        if (this.arenas.get(arena).fightHeroes()){
            countHeroesWins++;
            this.arenas.remove(arena);
            return String.format("Heroes won the battle of %s!%n", arena);
        } else {
            countAntiHeroesWins++;
            this.arenas.remove(arena);
            return String.format("Anti Heroes won the battle of %s!%n", arena);
        }
    }

    @Override
    public String endWar() {
        if (this.countHeroesWins >= this.countAntiHeroesWins){
            return String.format("After %d battles our FRIENDLY HEROES WON!%n", this.countHeroesWins + this.countAntiHeroesWins);
        }

        return String.format("WE ARE DOOMED!%n");
    }
}
