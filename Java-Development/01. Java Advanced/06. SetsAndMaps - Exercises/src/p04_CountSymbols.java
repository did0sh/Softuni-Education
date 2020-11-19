import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class p04_CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] input = reader.readLine().toCharArray();
        Map<Character, Integer> characters = new TreeMap<>();

        for (char ch : input) {
            if (!characters.containsKey(ch)){
                characters.put(ch, 1);
            } else {
                characters.put(ch, characters.get(ch) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : characters.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
