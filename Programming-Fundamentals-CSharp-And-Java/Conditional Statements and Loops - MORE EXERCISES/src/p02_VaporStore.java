import java.util.Scanner;

/**
 * Created by user on 25.9.2017 г..
 */
public class p02_VaporStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double balance = Double.parseDouble(scan.nextLine());
        double gamePrice = 0;
        double moneySpent = 0;


        while (balance > 0){
            String gameBought = scan.nextLine();

            switch (gameBought){
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    gamePrice = 39.99; break;
                case "CS: OG":
                    gamePrice = 15.99; break;
                case "Zplinter Zell":
                    gamePrice = 19.99; break;
                case "Honored 2":
                    gamePrice = 59.99; break;
                case "RoverWatch":
                    gamePrice = 29.99; break;
                case "Game Time":
                    System.out.printf("Total spent: $%.2f. Remaining: $%.2f", moneySpent, balance);
                    return;
                default:
                    System.out.printf("Not Found%n");
                    continue;


            }

            if (balance >= gamePrice){
                System.out.printf("Bought %s%n", gameBought);
                balance -= gamePrice;
                moneySpent += gamePrice;
            } else {
                System.out.printf("Too Expensive%n");
            }
        }

        System.out.printf("Out of money!");
    }
}
