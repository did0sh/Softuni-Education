import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p04_HighScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, ArrayList<Pair<String, Long>>> hashMap = new HashMap<>();
        String input = reader.readLine();
        while (!"osu!".equalsIgnoreCase(input)) {
            String[] tokens = input.split("[ <\\->]");
            long playerOneScore = Long.parseLong(tokens[0]);
            long playerTwoScore = Long.parseLong(tokens[5]);
            String firstPlayerName = tokens[1];
            String secondPlayerName = tokens[4];

            if (playerOneScore < playerTwoScore) {
                if (!hashMap.containsKey(firstPlayerName)) {
                    hashMap.put(firstPlayerName, new ArrayList<>());
                    Pair<String, Long> temporary = new Pair<>(secondPlayerName, playerOneScore - playerTwoScore);
                    hashMap.get(firstPlayerName).add(temporary);
                } else {
                    Pair<String, Long> temporary = new Pair<>(secondPlayerName, playerOneScore - playerTwoScore);
                    hashMap.get(firstPlayerName).add(temporary);
                }

                if (!hashMap.containsKey(secondPlayerName)) {
                    hashMap.put(secondPlayerName, new ArrayList<>());
                    Pair<String, Long> temporary = new Pair<>(firstPlayerName, Math.abs(playerTwoScore - playerOneScore));
                    hashMap.get(secondPlayerName).add(temporary);
                } else {
                    Pair<String, Long> temporary = new Pair<>(firstPlayerName, Math.abs(playerTwoScore - playerOneScore));
                    hashMap.get(secondPlayerName).add(temporary);
                }
            } else {
                if (!hashMap.containsKey(firstPlayerName)) {
                    hashMap.put(firstPlayerName, new ArrayList<>());
                    Pair<String, Long> temporary = new Pair<>(secondPlayerName, Math.abs(playerTwoScore - playerOneScore));
                    hashMap.get(firstPlayerName).add(temporary);
                } else {
                    Pair<String, Long> temporary = new Pair<>(secondPlayerName, Math.abs(playerTwoScore - playerOneScore));
                    hashMap.get(firstPlayerName).add(temporary);
                }

                if (!hashMap.containsKey(secondPlayerName)) {
                    hashMap.put(secondPlayerName, new ArrayList<>());
                    Pair<String, Long> temporary = new Pair<>(firstPlayerName, playerTwoScore - playerOneScore);
                    hashMap.get(secondPlayerName).add(temporary);
                } else {
                    Pair<String, Long> temporary = new Pair<>(firstPlayerName, playerTwoScore - playerOneScore);
                    hashMap.get(secondPlayerName).add(temporary);
                }
            }

            input = reader.readLine();
        }
        Map<String, Long> tempMap = new HashMap<>();

        for(String key :hashMap.keySet()) {
            long sum = 0;
            for (Pair<String, Long> stringLongPair : hashMap.get(key)) {
                sum += stringLongPair.getValue();
            }
            tempMap.put(key, sum);
        }

        List<String> sortedNames = new ArrayList<>(tempMap.keySet());
        Collections.sort(sortedNames,new Comparator<String>() {
            @Override
            public int compare (String s1, String s2){
                Long popularity1 = tempMap.get(s1);
                Long popularity2 = tempMap.get(s2);
                return popularity2.compareTo(popularity1);
            }
        });

        for(String name :sortedNames) {
            System.out.printf("%s - (%d)%n", name, tempMap.get(name));
            for (Pair<String, Long> pair : hashMap.get(name)) {
                System.out.printf("*   %s <-> %d%n", pair.getKey(), pair.getValue());
            }
        }
    }
}
