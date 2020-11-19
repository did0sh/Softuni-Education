package hell.repository;

import hell.interfaces.Hero;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class HeroRepository implements Repository<Hero> {
    private Map<String, Hero> heroes;

    public HeroRepository() {
        this.heroes = new LinkedHashMap<>();
    }

    @Override
    public void add(Hero hero) {
        this.heroes.put(hero.getName(), hero);
    }

    @Override
    public void remove(Hero hero) {
        this.heroes.remove(hero.getName());
    }

    @Override
    public Hero get(String elementName) {
        return this.heroes.get(elementName);
    }

    @Override
    public Collection<Hero> getAll() {
        return this.heroes.values();
    }
}
