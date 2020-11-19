import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p05_VowelCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Pattern pattern = Pattern.compile("[AaEeIiOoUuYy]");
        Matcher matcher = pattern.matcher(input);

        int count = 0;
        while (matcher.find()){
            count++;
        }
        System.out.printf("Vowels: %d", count);
    }
}
