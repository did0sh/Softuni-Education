import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class p07_ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> students = new LinkedHashMap<>();
        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)){

            String[] tokens = input.split("\\s+");
            String name = tokens[0] + " " + tokens[1];
            List<Integer> grades = new ArrayList<>();

            for (int i = 2; i < tokens.length; i++) {
                grades.add(Integer.parseInt(tokens[i]));
            }
            students.putIfAbsent(name, grades);
            input = reader.readLine();
        }

        students.entrySet().stream()
                .filter(kv -> kv.getValue().stream().anyMatch(num -> num == 6))
                .forEach(kv -> System.out.printf("%s%n", kv.getKey()));

    }
}
