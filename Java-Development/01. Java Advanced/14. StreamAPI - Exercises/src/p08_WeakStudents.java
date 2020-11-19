import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p08_WeakStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> students = new LinkedHashMap<>();
        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {

            List<String> tokens = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());
            String name = tokens.get(0) + " " + tokens.get(1);
            List<Integer> grades = tokens.subList(2, tokens.size()).stream().map(Integer::valueOf).collect(Collectors.toList());

            students.putIfAbsent(name, grades);
            input = reader.readLine();
        }

        students.entrySet().stream()
                .filter(filterStudents())
                .forEach(kv -> System.out.printf("%s%n", kv.getKey()));
    }

    private static Predicate<Map.Entry<String, List<Integer>>> filterStudents() {
        return s -> {
            List<Integer> grades = s.getValue();
            int count = 0;
            for (Integer grade : grades) {
                if (grade <= 3) {
                    count++;
                }
            }
            return count >= 2;
        };
    }
}
