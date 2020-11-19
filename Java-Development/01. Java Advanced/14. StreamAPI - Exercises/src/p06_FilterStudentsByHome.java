import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class p06_FilterStudentsByHome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> names = new LinkedHashMap<>();
        String input = reader.readLine();
        while (!"end".equalsIgnoreCase(input)){
            String[] tokens = input.split("\\s+");
            String name = tokens[0] + " " + tokens[1];
            String phone = tokens[2];
            names.putIfAbsent(name, phone);
            input = reader.readLine();
        }

        names.entrySet().stream()
                .filter(kv -> kv.getValue().startsWith("02") || kv.getValue().startsWith("+3592"))
                .forEach(kv -> System.out.printf("%s%n", kv.getKey()));
    }
}
