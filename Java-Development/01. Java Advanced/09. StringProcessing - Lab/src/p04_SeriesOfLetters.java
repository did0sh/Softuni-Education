import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p04_SeriesOfLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Pattern pattern = Pattern.compile("([A-Za-z ])\\1*");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            System.out.print(matcher.group(1));
        }
    }
}
