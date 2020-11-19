import java.text.DecimalFormat;
import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());
        double oddSum = 0;
        double oddMin = Integer.MAX_VALUE;
        double oddMax = Integer.MIN_VALUE;

        double evenSum = 0;
        double evenMin = Integer.MAX_VALUE;
        double evenMax = Integer.MIN_VALUE;

        for (int i = 1; i <= count ; i++) {
            double number = Double.parseDouble(scan.nextLine());

            if (i % 2 != 0){

                if (number < oddMin){
                    oddMin = number;
                }

                if (number > oddMax){
                    oddMax = number;
                }

                oddSum += number;
            } else {

                if (number < evenMin){
                    evenMin = number;
                }

                if (number > evenMax){
                    evenMax = number;
                }
                evenSum += number;
            }
        }

        DecimalFormat df = new DecimalFormat("#.##");

        if (count == 0){
            System.out.println("OddSum=0");
            System.out.println("OddMin=No");
            System.out.println("OddMax=No");
            System.out.println("EvenSum=0");
            System.out.println("EvenMin=No");
            System.out.println("EvenMax=No");
        } else if (count == 1){
            System.out.println("OddSum=" + df.format(oddSum));
            System.out.println("OddMin=" + df.format(oddMin));
            System.out.println("OddMax=" + df.format(oddMax));
            System.out.println("EvenSum=0");
            System.out.println("EvenMin=No");
            System.out.println("EvenMax=No");
        } else {
            System.out.println("OddSum=" + df.format(oddSum));
            System.out.println("OddMin=" + df.format(oddMin));
            System.out.println("OddMax=" + df.format(oddMax));
            System.out.println("EvenSum=" + df.format(evenSum));
            System.out.println("EvenMin=" + df.format(evenMin));
            System.out.println("EvenMax=" + df.format(evenMax));
        }


    }
}
