import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.*;

public class p05_FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] components = reader.readLine().split(", ");
            String name = components[0];
            int age = Integer.parseInt(components[1]);

            people.putIfAbsent(name,age);
        }

        String condition = reader.readLine();
        int ageCondition = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        Function<Map.Entry<String, Integer>, LinkedHashMap<String, Integer>> func = entry -> {
            LinkedHashMap<String, Integer> sorted = new LinkedHashMap<>();
            switch (condition){
                case "older":
                    if (entry.getValue() >= ageCondition){
                        sorted.put(entry.getKey(), entry.getValue());
                    }
                break;
                case "younger":
                    if (entry.getValue() < ageCondition){
                        sorted.put(entry.getKey(), entry.getValue());
                    }
                break;
            }
            return sorted;
        };

        LinkedHashMap<String, Integer> sorted = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : people.entrySet()) {
            if (!func.apply(entry).isEmpty()){
                sorted.put(entry.getKey(), entry.getValue());
            }
        }


        Consumer<Map.Entry<String,Integer>> print = entry ->{
            switch (format){
                case "name age":
                    System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
                    break;
                case "name":
                    System.out.printf("%s%n", entry.getKey());
                    break;
                case "age":
                    System.out.printf("%d%n", entry.getValue());
                    break;
            }
        };

        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
           print.accept(entry);
        }
    }
}
