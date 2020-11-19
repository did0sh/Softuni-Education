package p08_CardGame;

import java.util.LinkedHashMap;
import java.util.Map;

public class Card {
    private RankType rankType;
    private SuitType suitType;
    private Map<String, Card> deck;
    private int power;

    public Card() {
        this.deck = new LinkedHashMap<>();
        this.fillDeck();
    }

    public Card(RankType rankType, SuitType suitType) {
        this.rankType = rankType;
        this.suitType = suitType;
    }

    private void fillDeck() {
        for (SuitType suitType : SuitType.values()) {
            for (RankType rankType : RankType.values()) {
                Card card = new Card(rankType, suitType);
                this.deck.put(card.toString(),card);
            }
        }
    }

    public void printCards(){
        for (Map.Entry<String, Card> stringCardEntry : deck.entrySet()) {
            System.out.println(stringCardEntry.getKey());
        }
    }

    public boolean containsCard(String card){
        return this.deck.containsKey(card);
    }

    public Card removeCard(String card){
        Card card1 = this.deck.get(card);
        this.deck.remove(card);
        return card1;
    }

    public int calculatePower(){
        this.power = this.rankType.getRankPower() + this.suitType.getPower();
        return this.power;
    }

    public RankType getRankType() {
        return this.rankType;
    }

    public SuitType getSuitType() {
        return this.suitType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s of %s",
                this.getRankType().name(), this.getSuitType().name()));
        return sb.toString();
    }

    public int compareTo(Card o) {
        return Integer.compare(o.calculatePower(), this.calculatePower());
    }
}
