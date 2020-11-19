package p09_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person() {
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public List<Child> getChildren() {
        return this.children;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons.addAll(pokemons);
    }

    public void setParents(List<Parent> parents) {
        this.parents.addAll(parents);
    }

    public void setChildren(List<Child> children) {
        this.children.addAll(children);
    }
}
