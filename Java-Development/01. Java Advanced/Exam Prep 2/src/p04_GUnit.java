import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class p04_GUnit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Set<String>>> items = new LinkedHashMap<>();
        String pattern = "[A-Z][A-Za-z0-9]+";
        String otherPattern = "\\s\\|\\s";

        String mainPattern = String.format("%1$s%2$s%1$s%2$s%1$s", pattern, otherPattern);

        String input = reader.readLine();
        while (!"It's testing time!".equalsIgnoreCase(input)) {
           if (!input.matches(mainPattern)){
               input = reader.readLine();
               continue;
           }

           String[] tokens = input.split(otherPattern);
            String className = tokens[0];
            String methodName = tokens[1];
            String unitTest = tokens[2];

            Set<String> test = new LinkedHashSet<>();
            Map<String, Set<String>> methods = new LinkedHashMap<>();

            if (items.containsKey(className)){
                methods = items.get(className);
            }

            if (methods.containsKey(methodName)){
                test = methods.get(methodName);
            }

            test.add(unitTest);
            methods.put(methodName, test);
            items.put(className, methods);


            input = reader.readLine();
        }

        StringBuilder sb = new StringBuilder();
        items.entrySet().stream()
                .sorted((kv1,kv2) -> {
            int unitTests = kv1.getValue().values().stream().mapToInt(m -> m.size()).sum();
            int unitTestKv2 = kv2.getValue().values().stream().mapToInt(m -> m.size()).sum();
            int comparator = unitTestKv2 - unitTests;
            if (comparator != 0){
                return comparator;
            }

                    int methodsKv1 = kv1.getValue().size();
                    int methodsKv2 = kv2.getValue().size();
                    int comparatorMethods = methodsKv1 - methodsKv2;

                    if (comparatorMethods != 0) {
                        return comparatorMethods;
                    }

                    return kv1.getKey().compareTo(kv2.getKey());
                }).forEach(kv -> {
                    sb.append(String.format("%s:", kv.getKey())).append(System.lineSeparator());
                    kv.getValue().entrySet().stream().sorted((v1,v2) -> {
                        int sizeV1 = v1.getValue().size();
                        int sizeV2 = v2.getValue().size();

                        int comparator = sizeV2 - sizeV1;
                        if (comparator != 0){
                            return comparator;
                        }

                        return v1.getKey().compareTo(v2.getKey());
                    }).forEach(v1 -> {
                        sb.append(String.format("##%s", v1.getKey())).append(System.lineSeparator());
                        v1.getValue().stream().sorted((unitTest1, unitTest2) -> {
                            int length1 = unitTest1.length();
                            int lentgh2 = unitTest2.length();
                            int comparator = length1 - lentgh2;

                            if (comparator != 0){
                                return comparator;
                            }

                            return unitTest1.compareTo(unitTest2);
                        }).forEach(test -> {
                            sb.append(String.format("####%s", test)).append(System.lineSeparator());
                        });
                    });
        });

        System.out.print(sb);
    }
}
