package p02_CardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        for (RankType rankType : RankType.values()) {
            System.out.println(rankType);
        }
    }
}
