import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p09_MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";

        while (!"end".equals(input)){
            if (Pattern.matches(regex, input)){
                System.out.println(input);
            }
            input = reader.readLine();
        }
    }
}
