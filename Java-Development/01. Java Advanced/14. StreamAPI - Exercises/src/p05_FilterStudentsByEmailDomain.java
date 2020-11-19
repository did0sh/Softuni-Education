import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class p05_FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> names = new LinkedHashMap<>();
        String input = reader.readLine();
        while (!"end".equalsIgnoreCase(input)){
            String[] tokens = input.split("\\s+");
            String name = tokens[0] + " " + tokens[1];
            String email = tokens[2];
            names.putIfAbsent(name, email);
            input = reader.readLine();
        }

        names.entrySet().stream()
                .filter(kv -> kv.getValue().endsWith("@gmail.com"))
                .forEach(kv -> System.out.printf("%s%n", kv.getKey()));
    }
}
