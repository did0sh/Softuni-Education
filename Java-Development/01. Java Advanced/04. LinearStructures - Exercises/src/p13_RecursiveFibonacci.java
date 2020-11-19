import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p13_RecursiveFibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long fibonacci = getFibonacci(n+1);

        System.out.println(fibonacci);

    }

    private static long getFibonacci(int number){
        if (number == 1){
            return 1;
        } else if (number == 0){
            return 0;
        } else {
            return getFibonacci(number - 1) + getFibonacci(number - 2);
        }
    }
}
