import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = Integer.parseInt(scan.nextLine());
        double y = Double.parseDouble(scan.nextLine());
        int wineNeeded = Integer.parseInt(scan.nextLine());
        int numberOfWorkers = Integer.parseInt(scan.nextLine());

        double sumGrozde = x*y;
        double wine = (0.4 * sumGrozde)/2.5;

        if (wine >= wineNeeded){
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n", Math.floor(wine));
            double difference = Math.abs(wine - wineNeeded);
            double winePerPerson = difference / numberOfWorkers;
            System.out.printf("%.0f liters left -> %.0f liters per person.", Math.ceil(difference), Math.ceil(winePerPerson));
        } else {
            double difference = Math.abs(wine - wineNeeded);
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.",Math.floor(difference));
        }

    }
}
