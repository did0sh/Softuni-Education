import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p02_SplitByWordCasing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] splitted = input.split("[,;:.!/()\"\\\\\'\\[\\] ]");

        List<String> lowerCase = new ArrayList<>();
        List<String> upperCase = new ArrayList<>();
        List<String> mixedCase = new ArrayList<>();


        for (String word : splitted) {
            if (word.trim().length() == 0) {
                continue;
            }
            boolean isMixed = false;
            for (int i = 0; i < word.length(); i++) {
                if (!Character.isLetter(word.charAt(i))) {
                    mixedCase.add(word);
                    isMixed = true;
                    break;
                }
            }
            if (!isMixed) {
                if (word.toLowerCase().equals(word)) {
                    lowerCase.add(word);
                } else if (word.toUpperCase().equals(word)) {
                    upperCase.add(word);
                } else {
                    mixedCase.add(word);
                }
            }
        }


        System.out.printf("Lower-case: %s%n", String.join(", ", lowerCase));
        System.out.printf("Mixed-case: %s%n", String.join(", ", mixedCase));
        System.out.printf("Upper-case: %s%n", String.join(", ", upperCase));
    }
}
