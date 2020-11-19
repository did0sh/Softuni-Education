package p08_CardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player implements Comparable<Player> {
    private String name;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public boolean hasFullDeck() {
        return this.cards.size() == 5;
    }

    private Card getBiggestCard() {
        Card biggestCard = this.cards.stream()
                .sorted((card1, card2) -> Integer.compare(card2.calculatePower(), card1.calculatePower()))
                .collect(Collectors.toList()).get(0);
        return biggestCard;
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(this.getBiggestCard().calculatePower(), o.getBiggestCard().calculatePower());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s wins with %s of %s.", this.getName(),
                this.getBiggestCard().getRankType(), this.getBiggestCard().getSuitType()));
        return sb.toString();
    }

    public String getName() {
        return this.name;
    }
}
