import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class p08_HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Integer>> items = new LinkedHashMap<>();
        String input = reader.readLine();
        int power = 0;
        int multiply = 0;
        int cardValue = 0;

        while (!"JOKER".equals(input)) {
            String[] components = input.split(":");
            String name = components[0];
            String[] cards = components[1].trim().split(", ");

            if (!items.containsKey(name)) {
                items.put(name, new LinkedHashMap<>());
            }
            for (String card : cards) {
                if (!items.get(name).containsKey(card)) {
                    char[] symbols = card.toCharArray();
                    switch (symbols[0]) {
                        case '1':
                            power = 10;
                            break;
                        case '2':
                            power = 2;
                            break;
                        case '3':
                            power = 3;
                            break;
                        case '4':
                            power = 4;
                            break;
                        case '5':
                            power = 5;
                            break;
                        case '6':
                            power = 6;
                            break;
                        case '7':
                            power = 7;
                            break;
                        case '8':
                            power = 8;
                            break;
                        case '9':
                            power = 9;
                            break;
                        case 'J':
                            power = 11;
                            break;
                        case 'Q':
                            power = 12;
                            break;
                        case 'K':
                            power = 13;
                            break;
                        case 'A':
                            power = 14;
                            break;
                    }
                    switch (symbols[symbols.length - 1]) {
                        case 'S':
                            multiply = 4;
                            break;
                        case 'H':
                            multiply = 3;
                            break;
                        case 'D':
                            multiply = 2;
                            break;
                        case 'C':
                            multiply = 1;
                            break;
                    }
                    cardValue = power * multiply;
                    items.get(name).put(card, cardValue);
                }
            }
            input = reader.readLine();
        }


        for (String entry : items.keySet()) {
            int totalSum = 0;
            for (Map.Entry<String, Integer> card : items.get(entry).entrySet()) {
                totalSum += card.getValue();
            }
            System.out.printf("%s: %d%n", entry, totalSum);
        }
    }
}
