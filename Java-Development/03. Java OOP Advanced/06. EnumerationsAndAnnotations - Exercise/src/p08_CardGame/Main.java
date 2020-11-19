package p08_CardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstPlayerName = reader.readLine();
        String secondPlayerName = reader.readLine();

        Player firstPlayer = new Player(firstPlayerName);
        Player secondPlayer = new Player(secondPlayerName);

        Card deck = new Card();

        String input;
        while (!firstPlayer.hasFullDeck() || !secondPlayer.hasFullDeck()) {

            input = reader.readLine();
            String[] info = input.split("\\s+of\\s+");

            try {
                Card card = new Card(RankType.valueOf(info[0]), SuitType.valueOf(info[1]));

                if (!deck.containsCard(input)) {
                    System.out.println("Card is not in the deck.");
                    continue;
                }

                if (!firstPlayer.hasFullDeck()) {
                    Card card2 = deck.removeCard(input);
                    firstPlayer.addCard(card2);
                } else if (!secondPlayer.hasFullDeck()) {
                    Card card2 = deck.removeCard(input);
                    secondPlayer.addCard(card2);
                }

            } catch (IllegalArgumentException e) {
                System.out.println("No such card exists.");
            }
        }

        if (firstPlayer.compareTo(secondPlayer) > 0) {
            System.out.println(firstPlayer);
        } else {
            System.out.println(secondPlayer);
        }

    }
}
