import java.util.Scanner;

/**
 * Created by user on 1.10.2017 г..
 */
public class p15_FastPrimeCheckerRefactor {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int input = Integer.parseInt(scan.nextLine());


        for (int i = 2; i <= input; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if  (i % j == 0) {

                    isPrime = false;
                    break;
                }
            }

            String prime = Boolean.toString(isPrime);
            System.out.printf("%d -> %s%n", i, prime.substring(0,1).toUpperCase() + prime.substring(1));
        }

    }
}
