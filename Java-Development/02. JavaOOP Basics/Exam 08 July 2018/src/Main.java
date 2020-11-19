import entities.AntiHero;
import entities.ArenaImpl;
import entities.Hero;
import entities.Power;
import entities.antiHeroTypes.Titan;
import entities.antiHeroTypes.Villain;
import entities.heroTypes.DCHero;
import entities.heroTypes.MarvelHero;
import manager.WarManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String CHECK_CHARACTER = "CHECK_CHARACTER";
    private static final String REGISTER_HERO = "REGISTER_HERO";
    private static final String REGISTER_ANTI_HERO = "REGISTER_ANTI_HERO";
    private static final String BUILD_ARENA = "BUILD_ARENA";
    private static final String SEND_HERO = "SEND_HERO";
    private static final String SEND_ANTI_HERO = "SEND_ANTI_HERO";
    private static final String SUPER_POWER = "SUPER_POWER";
    private static final String ASSIGN_POWER = "ASSIGN_POWER";
    private static final String UNLEASH = "UNLEASH";
    private static final String COMICS_WAR = "COMICS_WAR";
    private static final String WAR_IS_OVER = "WAR_IS_OVER";


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        WarManager manager = new WarManager();

        String input;
        while (!WAR_IS_OVER.equalsIgnoreCase(input = reader.readLine())){
            String[] info = input.split("\\s+");
            switch (info[0]){
                case CHECK_CHARACTER:
                    sb.append(manager.checkComicCharacter(info[1]));
                    break;
                case REGISTER_HERO:
                    Hero hero = null;
                    switch (info[2]){
                        case "DCHero":
                            try {
                                hero = new DCHero(info[1], Integer.parseInt(info[3]),
                                        Double.parseDouble(info[4]), Double.parseDouble(info[5]),
                                        Double.parseDouble(info[6]));
                                sb.append(manager.addHero(hero));
                            }catch (IllegalArgumentException ex){
                                sb.append(ex.getMessage()).append(System.lineSeparator());
                            }

                            break;

                        case "MarvelHero":
                            try {
                                hero = new MarvelHero(info[1], Integer.parseInt(info[3]),
                                        Double.parseDouble(info[4]), Double.parseDouble(info[5]),
                                        Double.parseDouble(info[6]));
                                sb.append(manager.addHero(hero));
                            } catch (IllegalArgumentException ex){
                                sb.append(ex.getMessage()).append(System.lineSeparator());
                            }

                            break;

                    }
                    break;
                case REGISTER_ANTI_HERO:
                    AntiHero antiHero = null;
                    switch (info[2]){
                        case "Villain":
                            try {
                                antiHero = new Villain(info[1], Integer.parseInt(info[3]),
                                        Double.parseDouble(info[4]), Double.parseDouble(info[5]),
                                        Double.parseDouble(info[6]));
                                sb.append(manager.addAntiHero(antiHero));
                            } catch (IllegalArgumentException ex){
                                sb.append(ex.getMessage()).append(System.lineSeparator());
                            }
                            break;
                        case "Titan":
                            try {
                                antiHero = new Titan(info[1], Integer.parseInt(info[3]),
                                        Double.parseDouble(info[4]), Double.parseDouble(info[5]),
                                        Double.parseDouble(info[6]));
                                sb.append(manager.addAntiHero(antiHero));
                            } catch (IllegalArgumentException ex){
                                sb.append(ex.getMessage()).append(System.lineSeparator());
                            }
                            break;
                    }
                    break;
                case BUILD_ARENA:
                    try {
                        ArenaImpl arena = new ArenaImpl(info[1], Integer.parseInt(info[2]));
                        sb.append(manager.addArena(arena));
                    } catch (IllegalArgumentException ex){
                        sb.append(ex.getMessage()).append(System.lineSeparator());
                    }

                    break;
                case SEND_HERO:
                    sb.append(manager.addHeroToArena(info[1], info[2]));
                    break;
                case SEND_ANTI_HERO:
                    sb.append(manager.addAntiHeroToArena(info[1], info[2]));
                    break;
                case SUPER_POWER:
                    try {
                        Power power = new Power(info[1], Double.parseDouble(info[2]));
                        sb.append(manager.loadSuperPowerToPool(power));
                    } catch (IllegalArgumentException ex){
                        sb.append(ex.getMessage()).append(System.lineSeparator()) ;
                    }

                    break;
                case ASSIGN_POWER:
                    sb.append(manager.assignSuperPowerToComicCharacter(info[1], info[2]));
                    break;
                case UNLEASH:
                    sb.append(manager.usePowers(info[1]));
                    break;
                case COMICS_WAR:
                    try {
                        sb.append(manager.startBattle(info[1]));
                    } catch (IllegalArgumentException ex){
                        sb.append(ex.getMessage()).append(System.lineSeparator());
                    }

                    break;
            }
        }
        sb.append(manager.endWar());
        System.out.print(sb.toString());
    }
}
