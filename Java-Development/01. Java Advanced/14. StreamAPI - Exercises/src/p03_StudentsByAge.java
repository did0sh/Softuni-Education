import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class p03_StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> names = new LinkedHashMap<>();
        String input = reader.readLine();
        while (!"end".equalsIgnoreCase(input)){
            String[] tokens = input.split("\\s+");
            String name = tokens[0] + " " + tokens[1];
            int group = Integer.parseInt(tokens[2]);
            names.putIfAbsent(name, group);
            input = reader.readLine();
        }

        names.entrySet().stream()
                .filter(kv -> kv.getValue() >= 18 && kv.getValue() <= 24)
                .forEach(kv -> System.out.printf("%s %d%n", kv.getKey(), kv.getValue()));
    }
}
