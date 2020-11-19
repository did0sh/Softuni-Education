import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class p10_MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^\\+359(\\s|-)2\\1\\d{3}\\1\\d{4}$";
        String input = reader.readLine();
        while (!"end".equals(input)){
            if (Pattern.matches(regex, input)){
                System.out.println(input);
            }
            input = reader.readLine();
        }
    }
}
