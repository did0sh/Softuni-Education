import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p03_DharmaInitiative {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<Long, String>> items = new TreeMap<>();
        Map<String, String> validStations = new HashMap<>();

        items.put("Arrow", new LinkedHashMap<>());
        items.put("Hydra", new LinkedHashMap<>());
        items.put("Orchid", new LinkedHashMap<>());
        items.put("Pearl", new LinkedHashMap<>());
        items.put("Flame", new LinkedHashMap<>());

        validStations.put("Hydra", "Zoological Research.");
        validStations.put("Arrow", "Development of defensive strategies, and Intelligence gathering.");
        validStations.put("Flame", "Communication.");
        validStations.put("Pearl", "Psychological Research and/or Observation.");
        validStations.put("Orchid", "Space-time manipulation research, disguised as a Botanical station.");

        String input = reader.readLine();
        while (!"recruit".equalsIgnoreCase(input)) {
            String[] tokens = input.split(":");
            String personName = tokens[0];
            Long facilityNum = Long.parseLong(tokens[1]);
            String stationName = tokens[2];

            boolean isValidName = isAlpha(personName);

            if (validStations.containsKey(stationName)) {
                items.get(stationName).put(facilityNum, personName);
            }
            input = reader.readLine();
        }

        input = reader.readLine();
        if (input.equals("DHARMA Initiative")) {
            items.entrySet().stream()
                    .sorted((kv1, kv2) -> {
                        int sizeKV1 = kv1.getValue().size();
                        int sizeKV2 = kv2.getValue().size();
                        return Integer.compare(sizeKV2, sizeKV1);
                    }).forEach(kv -> System.out.printf("The %s has %d DHARMA recruits in it.%n", kv.getKey(), kv.getValue().size()));

        } else if (validStations.containsKey(input)) {
            System.out.printf("The %s station: %s%n", input, validStations.get(input));

            if (items.get(input).size() == 0) {
                System.out.println("No recruits");
            } else {
                String finalInput = input;
                items.get(input).keySet().stream()
                        .sorted(Comparator.reverseOrder())
                        .forEach(k -> System.out.printf("###%s - %d%n", items.get(finalInput).get(k), k));
            }
        } else {
            System.out.println("DHARMA Initiative does not have such a station!");
        }

    }

    private static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z\\s]+");
    }
}
