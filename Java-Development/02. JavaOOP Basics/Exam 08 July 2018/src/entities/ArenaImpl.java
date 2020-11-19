package entities;

import contracts.Arena;

import java.util.*;

public class ArenaImpl implements Arena {
    private String arenaName;
    private Map<String, Hero> heroes;
    private Map<String, AntiHero> antiHeroes;
    private int capacity;
    private int countBattles;

    public ArenaImpl(String arenaName, int capacity) {
        this.arenaName = arenaName;
        this.heroes = new LinkedHashMap<>();
        this.antiHeroes = new LinkedHashMap<>();
        this.capacity = capacity;
        this.getParticipants();
        this.isArenaFull();
    }

    public Map<String, Hero> getHeroes() {
        return Collections.unmodifiableMap(this.heroes);
    }

    public Map<String, AntiHero> getAntiHeroes() {
        return Collections.unmodifiableMap(this.antiHeroes);
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getParticipants() {
        return this.getHeroes().size() + this.getAntiHeroes().size();
    }

    public void setCountBattles(int countBattles) {
        this.countBattles = countBattles;
    }

    public int getCountBattles() {
        return this.countBattles;
    }

    @Override
    public String getArenaName() {
        return this.arenaName;
    }

    @Override
    public boolean isArenaFull() {
        if (this.getParticipants() == this.getCapacity()) {
            return true;
        }
        return false;
    }

    @Override
    public void addHero(Hero hero) {
        this.heroes.put(hero.getName(), hero);
    }

    @Override
    public void addAntiHero(AntiHero antiHero) {
        this.antiHeroes.put(antiHero.getName(), antiHero);
    }

    @Override
    public boolean fightHeroes() {
       this.setCountBattles(this.getCountBattles() + 1);
        boolean endFight = false;

       while (this.getHeroes().size() != 0 && this.getAntiHeroes().size() != 0){

            if (this.getHeroes().size() >= this.getAntiHeroes().size()) {
                List<String> antiHeroes = new ArrayList<>(this.getAntiHeroes().keySet());
                List<String> heroes = new ArrayList<>(this.getHeroes().keySet());

                for (int i = 0; i < antiHeroes.size(); i++) {
                    String currentObjAnti = antiHeroes.get(i);
                    String currentObjHeroes = heroes.get(i);

                    if (this.getHeroes().size() == 0) {
                        endFight = false;
                        break;// AntiHeroes Won!;
                    }

                    AntiHero antiHero = this.getAntiHeroes().get(currentObjAnti);
                    Hero hero = this.getHeroes().get(currentObjHeroes);

                    double antiHeroAttackPower = antiHero.attack();
                    hero.takeDamage(antiHeroAttackPower);

                    if (hero.getHealth() <= 0) {
                        this.getHeroes().remove(hero.getName());
                    }
                }
            }


            List<String> antiHeroes = new ArrayList<>(this.getAntiHeroes().keySet());
            List<String> heroes = new ArrayList<>(this.getHeroes().keySet());

            for (int i = 0; i < heroes.size(); i++) {
                String currentObjAnti = antiHeroes.get(i);
                String currentObjHeroes = heroes.get(i);

                if (this.getAntiHeroes().size() == 0) {
                   endFight = true;
                   break;//Heroes won!
                }

                AntiHero antiHero = this.getAntiHeroes().get(currentObjAnti);
                Hero hero = this.getHeroes().get(currentObjHeroes);

                double heroAttackPower = hero.attack();
                antiHero.takeDamage(heroAttackPower);

                if (antiHero.getHealth() <= 0) {
                    this.getAntiHeroes().remove(antiHero.getName());
                }
            }
        }
        this.getParticipants();
       this.isArenaFull();

        return endFight;

    }
}
