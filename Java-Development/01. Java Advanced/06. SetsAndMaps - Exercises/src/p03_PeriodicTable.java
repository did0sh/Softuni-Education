import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class p03_PeriodicTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Set<String> chemicals = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] components = reader.readLine().split("\\s+");
            Collections.addAll(chemicals, components);
        }

        for (String chemical : chemicals) {
            System.out.printf("%s ", chemical);
        }
    }
}
