import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p13_SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = reader.readLine();
        Pattern patternKey = Pattern.compile("\\b" + key + "\\b");
        Pattern pattern = Pattern.compile("[A-Z].+?([!.?])");

        String input = reader.readLine();
        Matcher matcher = pattern.matcher(input);
        ArrayList<String> matches = new ArrayList<>();
        while (matcher.find()){
            matches.add(matcher.group());
        }

        for (String match : matches) {
            Matcher matcher1 = patternKey.matcher(match);
            if (matcher1.find()){
                System.out.println(match);
            }
        }
    }
}
