import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> contestsAndPasses = new LinkedHashMap<>();
        TreeMap<String, LinkedHashMap<String, Long>> items = new TreeMap<>();

        String input = reader.readLine();
        while (!"end of contests".equalsIgnoreCase(input)) {
            String[] tokens = input.split(":", 2);
            String contest = tokens[0];
            String pass = tokens[1];
            contestsAndPasses.put(contest, pass);
            input = reader.readLine();
        }

        input = reader.readLine();
        while (!"end of submissions".equalsIgnoreCase(input)) {
            String[] tokens = input.split("=>");
            String contest = tokens[0];
            String pass = tokens[1];
            String contestantName = tokens[2];
            long points = Long.parseLong(tokens[3]);

            if (contestsAndPasses.containsKey(contest)) {
                if (contestsAndPasses.get(contest).equals(pass)) {

                    if (!items.containsKey(contestantName)) {
                        items.put(contestantName, new LinkedHashMap<>());
                        items.get(contestantName).put(contest, points);
                    } else {
                        if (!items.get(contestantName).containsKey(contest)) {
                            items.get(contestantName).put(contest, points);
                        } else {
                            long oldPoints = items.get(contestantName).get(contest);
                            if (points > oldPoints) {
                                items.get(contestantName).put(contest, points);
                            }
                        }
                    }
                }
            }
            input = reader.readLine();
        }

        items.entrySet().stream()
                .sorted((kv1, kv2) -> {
                    long sumKV1 = kv1.getValue().values().stream().mapToLong(m -> Long.parseLong(String.valueOf(m))).sum();
                    long sumKV2 = kv2.getValue().values().stream().mapToLong(m -> Long.parseLong(String.valueOf(m))).sum();

                    return Long.compare(sumKV2, sumKV1);
                }).limit(1).forEach(kv -> System.out.printf("Best candidate is %s with total %d points.%n", kv.getKey(),
                kv.getValue().values().stream().mapToLong(m -> Long.parseLong(String.valueOf(m))).sum()));


        System.out.printf("Ranking: %n");

        StringBuilder sb = new StringBuilder();


        for (String key : items.keySet()) {
            System.out.printf("%s%n", key);
            items.get(key).entrySet().stream().sorted((kv1, kv2) -> {
                long points1 = kv1.getValue();
                long points2 = kv2.getValue();
                return Long.compare(points2, points1);
            }).forEach(kv -> System.out.printf("#  %s -> %d%n", kv.getKey(), kv.getValue()));
        }
    }
}
