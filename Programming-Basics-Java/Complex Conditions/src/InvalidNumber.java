import java.util.Scanner;

public class InvalidNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double number = Double.parseDouble(scan.nextLine());
        boolean numberIsInRange = (number >= 100 && number <= 200) || (number == 0);

        if (!(numberIsInRange)) {
            System.out.println("Invalid".toLowerCase());
        }
    }
}
