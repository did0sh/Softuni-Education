import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class p11_LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Map<String, Integer> usersAndDuration = new TreeMap<>();
        Map<String, TreeMap<String, Integer>> allItems = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            if (!usersAndDuration.containsKey(user)){    // user and sum all duration
                usersAndDuration.put(user, duration);
            } else {
                usersAndDuration.put(user, usersAndDuration.get(user) + duration);
            }

            if (!allItems.containsKey(user)){   // user, ip, duration
                allItems.put(user, new TreeMap<>());
                allItems.get(user).put(ip, duration);
            } else {
                if (!allItems.get(user).containsKey(ip)){
                    allItems.get(user).put(ip, duration);
                }
            }
        }

        for (String key : usersAndDuration.keySet()) {
            System.out.printf("%s: %d ", key, usersAndDuration.get(key));
            ArrayList<String> output = new ArrayList<>();
            for (Map.Entry<String,Integer> entry : allItems.get(key).entrySet()) {
                output.add(entry.getKey());
            }
            System.out.println("[" + String.join(", ", output) + "]");
        }
    }
}
