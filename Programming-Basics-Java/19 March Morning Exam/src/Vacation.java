import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        double procentBudget = 0;

        if (budget <= 1000){
            if (season.equals("Summer")){
                procentBudget = budget*0.65;
                System.out.printf("Alaska - Camp - %.2f", procentBudget);
            } else if (season.equals("Winter")){
                procentBudget = budget*0.45;
                System.out.printf("Morocco - Camp - %.2f", procentBudget);
            }
        }

        if (budget > 1000 && budget <= 3000){
            if (season.equals("Summer")){
                procentBudget = budget*0.8;
                System.out.printf("Alaska - Hut - %.2f", procentBudget);
            } else if (season.equals("Winter")){
                procentBudget = budget*0.6;
                System.out.printf("Morocco - Hut - %.2f", procentBudget);
            }
        }

        if (budget > 3000){
            if (season.equals("Summer")){
                procentBudget = budget*0.9;
                System.out.printf("Alaska - Hotel - %.2f", procentBudget);
            } else if (season.equals("Winter")){
                procentBudget = budget*0.9;
                System.out.printf("Morocco - Hotel - %.2f", procentBudget);
            }
        }

    }
}
