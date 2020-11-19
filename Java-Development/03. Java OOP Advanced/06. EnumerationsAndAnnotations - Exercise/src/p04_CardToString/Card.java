package p04_CardToString;

public class Card {
    private RankType rankType;
    private SuitType suitType;
    private int power;

    public Card(String rankType, String suitType) {
        this.rankType = Enum.valueOf(RankType.class, rankType.toUpperCase());
        this.suitType = Enum.valueOf(SuitType.class, suitType.toUpperCase());
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
        sb.append(String.format("Card name: %s of %s; Card power: %d",
                this.getRankType().name(), this.getSuitType().name(), this.calculatePower()));
        return sb.toString();
    }
}
