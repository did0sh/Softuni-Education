import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class p13_InfernoIII {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] gems = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Map<String, Predicate<Integer>> changes = new HashMap<>();
        String input = reader.readLine();
        while (!"forge".equalsIgnoreCase(input)) {
            String[] tokens = input.split(";");
            Predicate<Integer> predict = createChanges(tokens[1], tokens[2], gems);
            switch (tokens[0]) {
                case "Exclude":
                    changes.put(tokens[1] + tokens[2], predict);
                    break;
                case "Reverse":
                    changes.remove(tokens[1] + tokens[2]);
                    break;
            }
            input = reader.readLine();

        }

        for(int i = 0; i<gems.length;i++) {
            boolean toRemove = false;
            for (Map.Entry<String, Predicate<Integer>> entry : changes.entrySet()) {
                if (entry.getValue().test(i)) {
                    toRemove = true;
                    break;
                }
            }
            if (!toRemove) {
                System.out.printf("%d ", gems[i]);
            }
        }
    }

    private static Predicate<Integer> createChanges(String filterType, String filterParam, int[] gems) {
        int value = Integer.parseInt(filterParam);
        switch (filterType) {
            case "Sum Left":
                return index -> (index > 0 ? gems[index - 1] : 0) + gems[index] == value;
            case "Sum Right":
                return index -> gems[index] + (index < gems.length - 1 ? gems[index + 1] : 0) == value;
            case "Sum Left Right":
                return index -> (index > 0 ? gems[index - 1] : 0) + gems[index] +
                        (index < gems.length - 1 ? gems[index + 1] : 0) == value;
        }
        return x -> Objects.equals(x, x);
    }
}
