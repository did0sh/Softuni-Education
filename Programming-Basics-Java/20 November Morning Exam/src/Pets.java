import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int daysAway = Integer.parseInt(scan.nextLine());
        int foodKg = Integer.parseInt(scan.nextLine());
        double dogFood = Double.parseDouble(scan.nextLine());
        double catFood = Double.parseDouble(scan.nextLine());
        double turtleFood = Double.parseDouble(scan.nextLine());



        double dogFoodNeeded = daysAway * dogFood;
        double catFoodNeeded = daysAway * catFood;
        double turtleFoodNeededInKg = (daysAway * turtleFood)/ 1000.00;

        double totalFoodNeeded = dogFoodNeeded + catFoodNeeded + turtleFoodNeededInKg;

        double difference = Math.abs(totalFoodNeeded - foodKg);

        if (totalFoodNeeded <= foodKg){
            System.out.printf("%d kilos of food left.", (int)Math.floor(difference));
        } else {
            System.out.printf("%d more kilos of food are needed.", (int)Math.ceil(difference));
        }
    }
}
