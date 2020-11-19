import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p11_StudentsJoinToSpecialties {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, LinkedHashSet<String>> studentSpecialties = new LinkedHashMap<>();
        Map<String, String> students = new HashMap<>();

        String input = reader.readLine();
        while (!"students:".equalsIgnoreCase(input)){
            String[] tokens = input.split("\\s+");
            String facNum = tokens[tokens.length-1];

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tokens.length - 1; i+= 2) {
                sb.setLength(0);
                sb.append(tokens[i]).append(" ").append(tokens[i+1]);

                if (!studentSpecialties.containsKey(facNum)){
                    studentSpecialties.put(facNum, new LinkedHashSet<>());
                }
                studentSpecialties.get(facNum).add(sb.toString());
            }
            input = reader.readLine();
        }

        input = reader.readLine();
        while (!"end".equalsIgnoreCase(input)){
            String[] tokens = input.split("\\s+");
            String facNum = tokens[0];
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < tokens.length - 1 ; i+=2) {
                sb.setLength(0);
                sb.append(tokens[i]).append(" ").append(tokens[i+1]);
               students.putIfAbsent(facNum, sb.toString());
            }
            input = reader.readLine();
        }

        Map<String,String> sorted = students.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1,v2) -> v2, LinkedHashMap::new));

        for (Map.Entry<String, String> entry : sorted.entrySet()) {
            String facNum = entry.getKey();
            String studentName = entry.getValue();
            for (String key : studentSpecialties.keySet()) {
                if(facNum.equals(key)){
                    for (String specialtyName : studentSpecialties.get(key)) {
                        System.out.printf("%s %s %s%n", studentName, facNum, specialtyName);
                    }
                    break;
                }
            }
        }
    }
}
