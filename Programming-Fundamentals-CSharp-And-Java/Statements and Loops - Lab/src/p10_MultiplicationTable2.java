import java.util.Scanner;

/**
 * Created by user on 21.9.2017 г..
 */
public class p10_MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        int start = Integer.parseInt(scan.nextLine());
        int result = 0;

        for (int i = start; i <= 10 ; i++) {
            result = i * number;
            System.out.printf("%d X %d = %d%n" , number, i, result);
        }

        if (start > 10){
            result = start * number;
            System.out.printf("%d X %d = %d%n" , number, start, result);
        }
    }
}
