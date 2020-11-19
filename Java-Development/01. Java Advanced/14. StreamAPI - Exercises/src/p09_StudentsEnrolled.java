import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class p09_StudentsEnrolled {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Integer>> students = new LinkedHashMap<>();
        String input = reader.readLine();
        while (!"end".equalsIgnoreCase(input)){
            List<String> tokens = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());
            String facultyNum = tokens.get(0);
            List<Integer> grades = tokens.subList(1, tokens.size()).stream().map(Integer::parseInt).collect(Collectors.toList());
            students.putIfAbsent(facultyNum, grades);
            input = reader.readLine();
        }

        students.entrySet().stream()
                .filter(kv -> kv.getKey().endsWith("14") || kv.getKey().endsWith("15"))
                .forEach(kv -> {
                    kv.getValue().stream().forEach(num -> System.out.printf("%d ", num));
                    System.out.println();
                });
    }
}
