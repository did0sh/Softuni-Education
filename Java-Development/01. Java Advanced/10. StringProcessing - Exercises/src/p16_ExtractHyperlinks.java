import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p16_ExtractHyperlinks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Pattern pattern = Pattern.compile("<a\\s+([^>]+)?href\\s*=\\s*('([^']*)'|\\\"([^\\\"]*)\\\"|([^\\s>]+))[^>]*>");
        StringBuilder sb = new StringBuilder();

        while (!"END".equals(input)){
            sb.append(input);
            input = reader.readLine();
        }

        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()){
            for (int i = 5; i >= 0; i--) {
                String result = matcher.group(i);
                if (result != null) {
                    System.out.println(result);
                    break;
                }
            }
        }

    }
}
