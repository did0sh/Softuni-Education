import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p09_MathPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] names = reader.readLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        int n = Integer.parseInt(reader.readLine());

        for (String name:names) {
            queue.offer(name);
        }

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(cycle)) {
                System.out.printf("Prime %s%n", queue.peek());
            } else {
                System.out.printf("Removed %s%n", queue.poll());
            }
            cycle++;
        }
            System.out.printf("Last is %s", queue.poll());

    }
    private static boolean isPrime(int num){
        if (num == 1){
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
