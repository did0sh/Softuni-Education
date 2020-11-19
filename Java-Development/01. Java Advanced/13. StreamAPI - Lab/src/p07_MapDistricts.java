import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p07_MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> cities = new HashMap<>();
        cities = addCities(cities,reader);
        int bound = Integer.parseInt(reader.readLine());

        cities.entrySet().stream().filter(x -> {
            int sumCity = x.getValue().stream().mapToInt(Integer::valueOf).sum();
            return sumCity > bound;
        }).sorted((kv1, kv2) -> {
            int kv1Sum = kv1.getValue().stream().mapToInt(Integer::valueOf).sum();
            int kv2Sum = kv2.getValue().stream().mapToInt(Integer::valueOf).sum();
            return Integer.compare(kv2Sum, kv1Sum);
        }).forEach(kv -> {
            StringBuilder sb = new StringBuilder();
            sb.append(kv.getKey()).append(": ");
            kv.getValue().stream().sorted((x, y) -> Integer.compare(y, x)).limit(5).forEach(num ->{
                sb.append(num).append(" ");
            });
            System.out.println(sb);
        });

    }
    private static Map<String, List<Integer>> addCities (Map<String, List<Integer>> cities, BufferedReader reader) throws IOException {
        String[] splittedInput = reader.readLine().split("\\s+");
        for (String s : splittedInput) {
            String[] tokens = s.split(":");
            String city = tokens[0];
            int districtPopulation = Integer.parseInt(tokens[1]);

            if (!cities.containsKey(city)){
                cities.put(city, new ArrayList<>());
            }
            cities.get(city).add(districtPopulation);
        }
        return cities;
    }
}
