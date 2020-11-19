import java.util.Scanner;

/**
 * Created by user on 23.9.2017 г..
 */
public class p02_ChooseADrink2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String profession = scan.nextLine();
        int quantity = Integer.parseInt(scan.nextLine());

        double waterPrice = 0.7;
        double coffeePrice = 1;
        double beerPrice = 1.70;
        double teaPrice = 1.20;
        double result = 0;


        switch (profession){
            case "Athlete":
                result = quantity * waterPrice;
                System.out.printf("The Athlete has to pay %.2f.", result); break;
            case "Businessman":
            case "Businesswoman":
                result = quantity * coffeePrice;
                System.out.printf("The %s has to pay %.2f.", profession, result); break;
            case "SoftUni Student":
                result = quantity * beerPrice;
                System.out.printf("The SoftUni Student has to pay %.2f.", result); break;
            default:
                result = quantity * teaPrice;
                System.out.printf("The %s has to pay %.2f.", profession, result); break;

        }

    }
}
