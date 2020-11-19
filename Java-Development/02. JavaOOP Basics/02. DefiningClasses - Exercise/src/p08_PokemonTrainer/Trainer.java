package p08_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfbadges;
    private List<Pokemon> pokemons;

    public Trainer(String name, int numberOfbadges) {
        this.name = name;
        this.numberOfbadges = numberOfbadges;
        this.pokemons = new ArrayList<>();
    }

    public int getNumberOfbadges() {
        return this.numberOfbadges;
    }

    public void setNumberOfbadges(int numberOfbadges) {
        this.numberOfbadges = numberOfbadges;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void addPokemons(List<Pokemon> pokes){
        this.pokemons.addAll(pokes);
    }
}
