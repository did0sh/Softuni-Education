import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p03_VLogger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, TreeSet<String>> followers = new HashMap<>();
        Map<String, HashSet<String>> following = new HashMap<>();

        String input = reader.readLine();
        while (!"statistics".equalsIgnoreCase(input)){
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String command = tokens[1];
            String otherName = tokens[2];

            if (command.equalsIgnoreCase("joined")){
                following.putIfAbsent(name, new HashSet<>());
                followers.putIfAbsent(name, new TreeSet<>());
            } else if (command.equalsIgnoreCase("followed")){
                if (!name.equals(otherName) && followers.containsKey(otherName) && following.containsKey(name)){
                    followers.get(otherName).add(name);
                    following.get(name).add(otherName);
                }
            }
            input = reader.readLine();
        }

        System.out.printf("The V-Logger has a total of %d vloggers in its logs.%n", followers.size());
        List<String> sorted = followers.keySet().stream()
                .sorted(Comparator.comparing((String x) -> followers.get(x).size(), Comparator.reverseOrder())
                        .thenComparing(y -> following.get(y).size())).collect(Collectors.toList());
        int count = 1;
        for (String s : sorted) {
            if (count == 1){
                System.out.printf("%d. %s : %d followers, %d following%n", count, s, followers.get(s).size(), following.get(s).size());
                for (String name : followers.get(s)) {
                    System.out.printf("*  %s%n", name);
                }
            } else {
                System.out.printf("%d. %s : %d followers, %d following%n", count, s, followers.get(s).size(), following.get(s).size());
            }
            count++;
        }
    }
}
