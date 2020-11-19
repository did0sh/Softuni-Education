import java.util.ArrayList;
import java.util.Scanner;

public class p10_IndexOfLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        ArrayList<Character> items = new ArrayList<Character>();

        for (int i = 0; i < input.length(); i++) {
            items.add(input.charAt(i));
        }

        for (int k = 0; k < items.size(); k++) {
            char currentLetter = items.get(k);
            int letterIndex = (int)currentLetter - 97;

            System.out.printf("%s -> %d%n", currentLetter, letterIndex);
        }
    }
}
