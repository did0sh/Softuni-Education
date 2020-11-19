package hell.commands;

import java.util.List;

public interface Executable {
    String executeHero(String name, String type) throws NoSuchFieldException, IllegalAccessException;
    String executeInspect(String heroName) throws NoSuchFieldException, IllegalAccessException;
    String executeItem(String name, String heroName, int strengthBonus,
                       int agilityBonus, int intelligenceBonus, int hitPointsBonus,  int damageBonus ) throws NoSuchFieldException, IllegalAccessException;
    String executeRecipe(String name, String heroName, int strengthBonus,
                         int agilityBonus, int intelligenceBonus,
                         int hitPointsBonus,  int damageBonus, List<String> requiredItems) throws NoSuchFieldException, IllegalAccessException;
    String executeQuit() throws NoSuchFieldException, IllegalAccessException;
}
