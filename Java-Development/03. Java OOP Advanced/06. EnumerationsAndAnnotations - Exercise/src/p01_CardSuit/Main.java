package p01_CardSuit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        for (SuitType suitType : SuitType.values()) {
            System.out.println(suitType);
        }
    }
}
