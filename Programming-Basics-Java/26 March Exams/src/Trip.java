import java.util.Scanner;

public class Trip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        double spending = 0;

        if (budget >= 10 && budget <= 100){
            if (season.equals("summer")){
                System.out.println("Somewhere in Bulgaria");
                spending = (30*budget)/100;
                System.out.printf("Camp - %.2f", spending);
            } else if (season.equals("winter")){
                System.out.println("Somewhere in Bulgaria");
                spending = (70*budget)/100;
                System.out.printf("Hotel - %.2f", spending);
            }
        }

        if (budget > 100 && budget <= 1000){
            if (season.equals("summer")){
                System.out.println("Somewhere in Balkans");
                spending = (40*budget)/100;
                System.out.printf("Camp - %.2f", spending);
            } else if (season.equals("winter")){
                System.out.println("Somewhere in Balkans");
                spending = (80*budget)/100;
                System.out.printf("Hotel - %.2f", spending);
            }
        }

        if (budget > 1000){
            System.out.println("Somewhere in Europe");
            spending = (90*budget)/100;
            System.out.printf("Hotel - %.2f", spending);
        }

    }
}
