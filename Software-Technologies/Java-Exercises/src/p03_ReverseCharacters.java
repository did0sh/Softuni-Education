import java.util.*;

public class p03_ReverseCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> items = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String letter = scan.nextLine();
            items.add(letter);
        }

        for (int i = items.size() - 1; i >= 0 ; i--) {
            System.out.printf("%s", items.get(i));
        }
    }
}
