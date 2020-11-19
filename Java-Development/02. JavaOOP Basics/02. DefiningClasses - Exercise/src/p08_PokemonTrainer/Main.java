package p08_PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Trainer> allTrainers = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!"tournament".equalsIgnoreCase(input)){
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName,pokemonElement,pokemonHealth);
            List<Pokemon> pokemons = new ArrayList<>();
            pokemons.add(pokemon);

            if (!allTrainers.containsKey(trainerName)){
                allTrainers.putIfAbsent(trainerName, new Trainer(trainerName, 0));
            }
              allTrainers.get(trainerName).addPokemons(pokemons);
            input = reader.readLine();
        }

        input = reader.readLine();
        while (!"end".equalsIgnoreCase(input)){
            String finalInput = input;
            List<Map.Entry<String, Trainer>> trainersWith1OrMorePokemons = allTrainers.entrySet().stream()
                    .filter(kv -> kv.getValue().getPokemons()
                    .stream().filter(pokemon -> pokemon.getElement().equals(finalInput))
                    .collect(Collectors.toList()).size() > 0)
                    .collect(Collectors.toList());

            List<Map.Entry<String, Trainer>> trainersWith0Pokemons = allTrainers.entrySet().stream()
                    .filter(kv -> kv.getValue().getPokemons()
                            .stream().filter(pokemon -> pokemon.getElement().equals(finalInput))
                            .collect(Collectors.toList()).size() == 0)
                    .collect(Collectors.toList());

            for (Map.Entry<String, Trainer> trainersWith0Pokemon : trainersWith0Pokemons) {
                trainersWith0Pokemon.getValue().getPokemons().forEach(pokemon -> pokemon.setHealth(pokemon.getHealth() - 10));
                trainersWith0Pokemon.getValue().getPokemons().removeIf(pokemon -> pokemon.getHealth() <= 0);
            }

            for (Map.Entry<String, Trainer> trainer : trainersWith1OrMorePokemons) {
                int currNumberOfBadges = trainer.getValue().getNumberOfbadges();
                trainer.getValue().setNumberOfbadges(currNumberOfBadges + 1);
            }
            input = reader.readLine();
        }

        allTrainers.entrySet().stream()
                .sorted((kv1,kv2) -> Integer.compare(kv2.getValue().getNumberOfbadges(), kv1.getValue().getNumberOfbadges()))
                .forEach(kv -> System.out.printf("%s %d %d%n", kv.getKey(), kv.getValue().getNumberOfbadges(), kv.getValue().getPokemons().size()));
    }
}
