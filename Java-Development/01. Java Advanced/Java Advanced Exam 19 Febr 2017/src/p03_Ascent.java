import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03_Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("([,_])([A-Za-z]+)(\\d)");
        String text = reader.readLine();
        Map<String, String> hashmap = new LinkedHashMap<>();

        while (!"ascend".equalsIgnoreCase(text)) {
            text = encryptTextWithOldValues(text, hashmap);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                StringBuilder sb = new StringBuilder();
                String symbol = matcher.group(1);
                String word = matcher.group(2);
                int num = Integer.parseInt(matcher.group(3));
                char[] characters = word.toCharArray();
                switch (symbol) {
                    case ",":
                        for (char character : characters) {
                            character = (char) (character + num);
                            sb.append(character);
                        }
                        text = text.replace(matcher.group(0), sb);
                        hashmap.putIfAbsent(matcher.group(0), sb.toString());
                        break;
                    case "_":
                        for (char character : characters) {
                            character = (char) (character - num);
                            sb.append(character);
                        }
                        text = text.replace(matcher.group(0), sb);
                        hashmap.putIfAbsent(matcher.group(0), sb.toString());
                        break;
                }
            }

            System.out.println(text);
            text = reader.readLine();
        }
    }

    private static String encryptTextWithOldValues(String text, Map<String, String> hashmap) {
        for (Map.Entry<String, String> entry : hashmap.entrySet()) {
            text = text.replace(entry.getKey(), entry.getValue());
        }
        return text;
    }
}
