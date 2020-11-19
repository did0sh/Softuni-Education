import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int juniors = Integer.parseInt(scan.nextLine());
        int seniors = Integer.parseInt(scan.nextLine());
        String type = scan.nextLine();

        double juniorsTax = 0.0;
        double seniorsTax = 0.0;

        if (type.equals("trail")){
            juniorsTax = 5.50;
            seniorsTax = 7;
        } else if (type.equals("cross-country")){
            if ((juniors + seniors) >= 50){
                juniorsTax = 8 - 0.25*8;
                seniorsTax = 9.50 - 0.25*9.50;
            } else {
                juniorsTax = 8;
                seniorsTax = 9.50;
            }
        } else if (type.equals("downhill")){
            juniorsTax = 12.25;
            seniorsTax = 13.75;
        } else if (type.equals("road")){
            juniorsTax = 20;
            seniorsTax = 21.50;
        }

        double sum = juniorsTax*juniors + seniorsTax*seniors;
        double razhod = 0.05*sum;

        double leftMoney = sum - razhod;

        System.out.printf("%.2f", leftMoney);
    }
}
