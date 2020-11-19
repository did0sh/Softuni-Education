import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class p02_SetsOfElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] components = reader.readLine().split(" ");
        int firstSetSize = Integer.parseInt(components[0]);
        int secondSetSize = Integer.parseInt(components[1]);

        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();

        for (int i = 0; i < firstSetSize; i++) {
            set1.add(Integer.parseInt(reader.readLine()));
        }
        for (int i = 0; i < secondSetSize; i++) {
            set2.add(Integer.parseInt(reader.readLine()));
        }

        for (Integer num : set1) {
            if (set2.contains(num)){
                System.out.print(num + " ");
            }
        }
    }
}
