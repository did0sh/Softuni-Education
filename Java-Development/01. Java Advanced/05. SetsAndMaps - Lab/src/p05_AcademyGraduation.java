import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class p05_AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Double> treeMap = new TreeMap<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String name = reader.readLine();
            String[] components = reader.readLine().split("\\s+");
            double average = 0;
            for (String note:components) {
                average += Double.parseDouble(note);
            }
            average /= components.length;

            treeMap.put(name, average);
        }

        for (Map.Entry<String, Double> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " is graduated with " + entry.getValue());
        }
    }
}
