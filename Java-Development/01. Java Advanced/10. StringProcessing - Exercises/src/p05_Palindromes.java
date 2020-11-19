import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

public class p05_Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("[\\s\\.,?!]");
        StringBuilder sb = new StringBuilder();
        TreeSet<String> words = new TreeSet<>();

        for (String word : input) {
            sb.append(word);
            if (sb.toString().equals(sb.reverse().toString()) && !word.equals("")){
                words.add(word);
            }
            sb.setLength(0);
        }
        System.out.println(words);
    }
}
