import java.util.Scanner;

/**
 * Created by user on 3.10.2017 г..
 */
public class p09_MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        num = Math.abs(num);
        int result = getSumOfEvensAndOdds(num);

        System.out.println(result);


    }

    static int getSumOfEvensAndOdds (int num){

        int evensMultiply = sumOfEvens(num);
        int oddsMultiply = sumOffOdds(num);
        return evensMultiply * oddsMultiply;
    }

    static int sumOfEvens (int num){

        int sum = 0;

        while (num > 0){
            int lastDigit = num%10;

            if (lastDigit % 2 == 0){
                sum += lastDigit;
            }

            num = num/10;


        }
        return sum;
    }


    static int sumOffOdds (int num){

        int sum = 0;

        while (num > 0){
            int lastDigit = num%10;

            if (lastDigit % 2 == 1){
                sum += lastDigit;
            }

            num = num/10;

        }
        return sum;
    }
}
