import java.util.Scanner;

/**
 * Created by user on 21.9.2017 г..
 */
public class p02_PassedOrFailed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        double grade  = Double.parseDouble(scan.nextLine());

        if (grade >= 3){
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }
    }
}
