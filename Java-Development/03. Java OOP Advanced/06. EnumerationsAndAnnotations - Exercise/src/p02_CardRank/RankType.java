package p02_CardRank;

public enum  RankType {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Ordinal value: %d; Name value: %s", this.ordinal(), this.name()));
        return sb.toString();
    }
}
