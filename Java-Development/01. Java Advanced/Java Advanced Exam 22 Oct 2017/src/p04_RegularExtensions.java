import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p04_RegularExtensions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        String input = reader.readLine();
        StringBuilder sb = new StringBuilder(text);
        while (!"print".equalsIgnoreCase(input)){
            String[] tokens = input.split("%", -1);
            for (int i = 0; i < tokens.length; i++) {
                tokens[i] = Pattern.quote(tokens[i]);
            }
            Pattern pattern = Pattern.compile(String.join("\\S*", tokens));
            Matcher matcher = pattern.matcher(sb);
            while (matcher.find()){
                StringBuilder replacement = new StringBuilder(sb.substring(matcher.start(), matcher.end())).reverse();
                sb.replace(matcher.start(), matcher.end(), replacement.toString());
            }
            input = reader.readLine();
        }
        System.out.println(sb);
    }
}
