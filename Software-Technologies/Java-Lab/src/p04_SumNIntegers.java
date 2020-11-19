
import java.util.Scanner;

public class p04_SumNIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scan.nextLine());
            sum+= num;
        }
        System.out.println("Sum = " + sum);
    }
}
