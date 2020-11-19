import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class p09_UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        TreeMap<String, LinkedHashMap<String, Integer>> items = new TreeMap<>();

        while (!"end".equals(input)){
            String[] tokens = input.split("\\s+");
            String ip = tokens[0].trim().split("=")[1];
            String username = tokens[2].trim().split("=")[1];

            if (!items.containsKey(username)){
                items.put(username, new LinkedHashMap<>());
                items.get(username).put(ip, 1);
            } else {
                if (!items.get(username).containsKey(ip)){
                    items.get(username).put(ip, 1);
                } else {
                    items.get(username).put(ip, items.get(username).get(ip) + 1);
                }
            }
            input = reader.readLine();
        }

        for (String key : items.keySet()) {
            System.out.printf("%s:%n", key);
            ArrayList<String> output = new ArrayList<>();
            for (Map.Entry<String,Integer> entry : items.get(key).entrySet()) {
                output.add(entry.getKey() + " => " + entry.getValue());
            }
            System.out.println(String.join(", ", output) + ".");
        }
    }
}
