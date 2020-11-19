package p01_CardSuit;

public enum SuitType {
    CLUBS, DIAMONDS, HEARTS, SPADES;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Ordinal value: %d; Name value: %s", this.ordinal(), this.name()));
        return sb.toString();
    }
}
