import java.util.Scanner;

/**
 * Created by user on 23.9.2017 г..
 */
public class p01_ChooseADrink {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String profession = scan.nextLine();

        switch (profession){
            case "Athlete":
                System.out.println("Water"); break;
            case "Businessman":
            case "Businesswoman":
                System.out.println("Coffee"); break;
            case "SoftUni Student":
                System.out.println("Beer"); break;
                default:
                    System.out.println("Tea"); break;

        }
    }
}
