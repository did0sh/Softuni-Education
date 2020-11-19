import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p13_OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Map<String, LinkedHashMap<String, Long>> items = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> tokens = Arrays.stream(reader.readLine().split("[\\|\\s+\\-]")).filter(x -> !x.isEmpty()).collect(Collectors.toList());
            String company = tokens.get(0);
            long amount = Long.parseLong(tokens.get(1));
            String product = tokens.get(2);

            if (!items.containsKey(company)){
                items.put(company, new LinkedHashMap<>());
                items.get(company).put(product, amount);
            } else {
                if (!items.get(company).containsKey(product)){
                    items.get(company).put(product, amount);
                } else {
                    items.get(company).put(product, items.get(company).get(product) + amount);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder values = new StringBuilder();
        List<String> appended = new ArrayList<>();

        items.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(kv -> {
                    sb.setLength(0);
                    appended.clear();

                    sb.append(kv.getKey()).append(": ");
                    kv.getValue().entrySet().stream().forEach(kv1 -> {
                        values.setLength(0);
                        values.append(kv1.getKey()).append("-").append(kv1.getValue());
                        appended.add(values.toString());
                    });
                    sb.append(String.join(", ", appended));

                    System.out.println(sb.toString());
                });
    }
}
