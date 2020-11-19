import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class p02_StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> names = new LinkedHashSet<>();
        String name = reader.readLine();
        while (!"end".equalsIgnoreCase(name)) {
            names.add(name);
            name = reader.readLine();
        }

        names.stream()
                .filter(str -> {
                    String firstString = str.split("\\s+")[0];
                    String secondString = str.split("\\s+")[1];

                    return firstString.compareTo(secondString) < 0;
                })
                .forEach(System.out::println);
    }
}
