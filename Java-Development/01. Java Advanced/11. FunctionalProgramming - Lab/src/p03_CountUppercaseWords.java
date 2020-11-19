import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Predicate;

public class p03_CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] text = reader.readLine().split("\\s+");
        Predicate<String> testUpperCase = word -> {
            return word.charAt(0) == word.toUpperCase().charAt(0);
        };

        ArrayList<String> words = new ArrayList<>();
        for (String s : text) {
            if (testUpperCase.test(s)){
                words.add(s);
            }
        }

        System.out.println(words.size());
        words.forEach(System.out::println);

    }
}
