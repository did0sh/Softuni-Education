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
        String input = reader.readLine();
        Pattern pattern = Pattern.compile("(,|_)([A-Za-z]+)(\\d)");
        Map<String,String> items = new LinkedHashMap<>();

        while (!"ascend".equalsIgnoreCase(input)){
            input = decrypt(input, items);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()){
                StringBuilder sb = new StringBuilder();
                if (matcher.group(1).equals(",")){
                    int num = Integer.parseInt(matcher.group(3));
                    char[] letters = matcher.group(2).toCharArray();
                    for (char letter : letters) {
                        letter = (char)(letter + num);
                        sb.append(letter);
                    }
                    items.putIfAbsent(matcher.group(0), sb.toString());
                    input = input.replace(matcher.group(), sb.toString());
                } else {
                    int num = Integer.parseInt(matcher.group(3));
                    char[] letters = matcher.group(2).toCharArray();
                    for (char letter : letters) {
                        letter = (char)(letter - num);
                        sb.append(letter);
                    }
                    items.putIfAbsent(matcher.group(0), sb.toString());
                    input = input.replace(matcher.group(), sb.toString());
                }
            }
            System.out.println(input);
            input = reader.readLine();
        }
    }

    private static String decrypt(String input, Map<String, String> items) {
        for (Map.Entry<String, String> entry : items.entrySet()) {
           input = input.replaceAll(entry.getKey(), entry.getValue());
        }
        return input;
    }
}
