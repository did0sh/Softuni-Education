
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class p06_AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> items = new LinkedHashMap<>();


        while (true){
            String resource = reader.readLine();
            if ("stop".equals(resource)){
                break;
            }
            int quantity = Integer.parseInt(reader.readLine());

            if (!items.containsKey(resource)){
                items.put(resource, quantity);
            } else {
                items.put(resource, items.get(resource) + quantity);
            }
        }

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
