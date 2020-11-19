import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p10_GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, LinkedHashSet<String>> students = new HashMap<>();
        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)){
            List<String> tokens = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());
            int group = Integer.parseInt(tokens.get(tokens.size()-1));

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tokens.size() - 2; i++) {
                sb.setLength(0);
                sb.append(tokens.get(i)).append(" ").append(tokens.get(i+1));

                if (!students.containsKey(group)){
                    students.put(group, new LinkedHashSet<>());
                }
                students.get(group).add(sb.toString());

            }


            input = reader.readLine();
        }

        students.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(kv -> System.out.printf("%d - %s%n", kv.getKey(), String.join(", ", kv.getValue())));
    }
}
