import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p04_FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Pair<String, String>>> items = new HashMap<>();
        String input = reader.readLine();
        StringBuilder sb = new StringBuilder();
        while (!"season end".equalsIgnoreCase(input)) {
            sb.setLength(0);
            List<String> tokens = Arrays.stream(input.split("[\\-\\s+]")).filter(x -> !x.isEmpty()).collect(Collectors.toList());
            String team = tokens.get(0);
            String otherTeam = tokens.get(1);
            sb.append(tokens.get(3));

            Pair<String, String> opponentAndScore = new Pair<>(otherTeam, sb.toString());
            if (!items.containsKey(team)){
                items.put(team, new ArrayList<>());
                items.get(team).add(opponentAndScore);
            } else {
                items.get(team).add(opponentAndScore);
            }


            sb.reverse();
            Pair<String, String> reversed = new Pair<>(team, sb.toString());

            if (!items.containsKey(otherTeam)) {
                items.put(otherTeam, new ArrayList<>());
                items.get(otherTeam).add(reversed);
            } else {
                items.get(otherTeam).add(reversed);
            }

            input = reader.readLine();
        }

        String[] teams = reader.readLine().split(", ");
        for (String team : teams) {
            items.get(team).stream().sorted((kv1, kv2) -> {
                String name = kv1.getKey();
                String opponentName = kv2.getKey();
                return name.compareTo(opponentName);
            }).forEach(kv -> System.out.printf("%s - %s -> %s%n", team, kv.getKey(), kv.getValue()));
        }
    }
}
