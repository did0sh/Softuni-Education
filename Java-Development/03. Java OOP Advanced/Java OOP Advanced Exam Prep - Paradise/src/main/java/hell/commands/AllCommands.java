package hell.commands;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import hell.repository.HeroRepository;
import hell.repository.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AllCommands implements Executable {
    private Repository<Hero> repository;

    public AllCommands() {
        this.repository = new HeroRepository();
    }

    @Override
    public String executeHero(String name, String type) throws NoSuchFieldException, IllegalAccessException {
        Hero hero = null;
        switch (type) {
            case "Barbarian":
                hero = new Barbarian(name);
                break;
            case "Assassin":
                hero = new Assassin(name);
                break;
            case "Wizard":
                hero = new Wizard(name);
                break;
        }

        this.repository.add(hero);
        return String.format("Created %s - %s", type, name);
    }

    @Override
    public String executeInspect(String heroName) throws NoSuchFieldException, IllegalAccessException {
        return this.repository.get(heroName).toString();
    }

    @Override
    public String executeItem(String name, String heroName, int strengthBonus,
                              int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus)
            throws NoSuchFieldException, IllegalAccessException {

        Item commonItem = new CommonItem(name, strengthBonus, agilityBonus,
                intelligenceBonus, hitPointsBonus, damageBonus);

        this.repository.get(heroName).addItem(commonItem);
        return String.format("Added item - %s to Hero - %s", name, heroName);
    }

    @Override
    public String executeRecipe(String name, String heroName, int strengthBonus,
                                int agilityBonus, int intelligenceBonus,
                                int hitPointsBonus, int damageBonus, List<String> requiredItems) throws NoSuchFieldException, IllegalAccessException {


        Recipe recipeItem = new RecipeItem(name, strengthBonus, agilityBonus,
                intelligenceBonus, hitPointsBonus, damageBonus, requiredItems);

        this.repository.get(heroName).addRecipe(recipeItem);
        return String.format("Added recipe - %s to Hero - %s", name, heroName);
    }

    @Override
    public String executeQuit() throws NoSuchFieldException, IllegalAccessException {
        Collection<Hero> allHeroes = this.repository.getAll();
        List<Hero> sortedHeroes = allHeroes.stream().sorted((hero1, hero2) -> {
            long h1Sum = hero1.getStrength() + hero1.getIntelligence() + hero1.getAgility();
            long h2Sum = hero2.getStrength() + hero2.getIntelligence() + hero2.getAgility();

            if (Long.compare(h2Sum, h1Sum) == 0) {
                long h1Other = hero1.getHitPoints() + hero1.getDamage();
                long h2Other = hero2.getHitPoints() + hero2.getDamage();
                return Long.compare(h2Other, h1Other);
            }

            return Long.compare(h2Sum, h1Sum);
        }).collect(Collectors.toList());

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (Hero sortedHero : sortedHeroes) {
            count++;

            ArrayList<String> heroItems = new ArrayList<>();
            sortedHero.getItems().forEach(item -> heroItems.add(item.getName()));

            sb.append(String.format("%d. %s: %s%n", count, sortedHero.getClass().getSimpleName(), sortedHero.getName()))
                    .append(String.format("###HitPoints: %d%n", sortedHero.getHitPoints()))
                    .append(String.format("###Damage: %d%n", sortedHero.getDamage()))
                    .append(String.format("###Strength: %d%n", sortedHero.getStrength()))
                    .append(String.format("###Agility: %d%n", sortedHero.getAgility()))
                    .append(String.format("###Intelligence: %d%n", sortedHero.getIntelligence()));

            if (heroItems.isEmpty()) {
                sb.append(String.format("###Items: None"));
            } else {
                sb.append(String.format("###Items: %s%n", String.join(", ", heroItems)));
            }

        }

        return sb.toString().trim();
    }
}
