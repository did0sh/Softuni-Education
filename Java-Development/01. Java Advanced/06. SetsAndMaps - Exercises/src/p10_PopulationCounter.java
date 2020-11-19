import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class p10_PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Map<String, Long> countriesPopulation = new LinkedHashMap<>();
        Map<String, HashMap<String, Long>> countriesCitiesPopulation = new LinkedHashMap<>();

        while (!"report".equals(input)){
            String[] tokens = input.split("\\|");

            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);
            String city = tokens[0];

            if (!countriesPopulation.containsKey(country)){  // add countries and sum the population
                countriesPopulation.put(country, population);
            } else {
                countriesPopulation.put(country, countriesPopulation.get(country) + population);
            }

            if (!countriesCitiesPopulation.containsKey(country)){            // add countries cities and population
                countriesCitiesPopulation.put(country, new HashMap<>());
                countriesCitiesPopulation.get(country).put(city, population);
            } else {
                if (!countriesCitiesPopulation.get(country).containsKey(city)){
                    countriesCitiesPopulation.get(country).put(city, population);
                }
            }
            input = reader.readLine();
        }

        Map<String, Long> countriesSorted = new LinkedHashMap<>(); // put sorted into new map
        countriesPopulation.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(x -> countriesSorted.put(x.getKey(), x.getValue()));


        for (String key : countriesSorted.keySet()) {
            System.out.printf("%s (total population: %d)%n", key, countriesSorted.get(key));
            countriesCitiesPopulation.get(key).entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                    .forEachOrdered(x -> System.out.printf("=>%s: %d%n", x.getKey(), x.getValue()));
        }
    }
}
