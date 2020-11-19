import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();

        double summerCabrio = 0.0;
        double winterJeep = 0.0;

        if (budget <= 100){
            System.out.println("Economy class");
            if (season.equals("Summer")){
                summerCabrio = 0.35*budget;
                System.out.printf("Cabrio - %.2f", summerCabrio);
            } else  if (season.equals("Winter")){
                winterJeep = 0.65*budget;
                System.out.printf("Jeep - %.2f", winterJeep);
            }
        }


        if (budget > 100 && budget <= 500){
            System.out.println("Compact class");
            if (season.equals("Summer")){
                summerCabrio = 0.45*budget;
                System.out.printf("Cabrio - %.2f", summerCabrio);
            } else  if (season.equals("Winter")){
                winterJeep = 0.80*budget;
                System.out.printf("Jeep - %.2f", winterJeep);
            }
        }


        if (budget > 500){
            System.out.println("Luxury class");
           winterJeep = 0.90*budget;
            System.out.printf("Jeep - %.2f", winterJeep);
        }

    }
}
