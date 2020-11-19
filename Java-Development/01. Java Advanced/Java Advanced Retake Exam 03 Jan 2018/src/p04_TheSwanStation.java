import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p04_TheSwanStation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        ArrayList<Integer> results = new ArrayList<>();

        String[] input = reader.readLine().split("\\s+");
        ArrayList<Integer> queue = new ArrayList<>();
        for (String s : input) {
            queue.add(Integer.parseInt(s));
        }

        while (numbers.size() != 0) {
            for (int i = 0; i < queue.size(); i++) {
                int currentInteger = queue.get(i);
                if (currentInteger % numbers.get(0) == 0) {
                    results.add(currentInteger);
                    numbers.remove(0);
                    if (numbers.size() == 0){
                        break;
                    }
                    queue.remove(i);
                    i--;
                } else {
                    queue.remove(i);
                    queue.add(queue.size(), currentInteger + 1);
                    i--;
                }
            }
        }

        System.out.println(results.toString().replaceAll("[\\[\\]]", ""));

    }
}
