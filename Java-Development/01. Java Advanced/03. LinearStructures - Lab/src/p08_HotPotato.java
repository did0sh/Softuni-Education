import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p08_HotPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] names = reader.readLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        int n = Integer.parseInt(reader.readLine());

        for (String name:names) {
            queue.offer(name);
        }

        while (queue.size() > 1){
            for (int i = 1; i < n ; i++) {
                queue.offer(queue.poll());
            }
            System.out.printf("Removed %s%n", queue.poll());
        }
        System.out.printf("Last is %s", queue.poll());
    }
}
