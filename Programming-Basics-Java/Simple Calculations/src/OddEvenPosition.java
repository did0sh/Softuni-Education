import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());
        double oddMin = Integer.MAX_VALUE;
        double oddMax = Integer.MIN_VALUE;
        double oddSum = 0;

        double evenMin = Integer.MAX_VALUE;
        double evenMax = Integer.MIN_VALUE;
        double evenSum = 0;

        for (int i = 1; i <= count ; i++) {
            double number = Double.parseDouble(scan.nextLine());
            if (i % 2 == 0){
                if (evenMin < number); {
                    number = evenMin;
                }
                evenSum += number;
            } else {
                oddSum += number;
            }

        }
    }
}
