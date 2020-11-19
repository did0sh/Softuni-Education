import java.util.Scanner;

/**
 * Created by user on 21.9.2017 г..
 */
public class p09_MultiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        int result = 0;

        for (int i = 1; i <= 10 ; i++) {
            result = i * number;
            System.out.printf("%d X %d = %d%n" , number, i, result);
        }
    }
}
