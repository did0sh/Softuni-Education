import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class p01_UniqueUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> usernames = new LinkedHashSet<>();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String name = reader.readLine();
            usernames.add(name);
        }

        for (String name : usernames) {
            System.out.println(name);
        }
    }
}
