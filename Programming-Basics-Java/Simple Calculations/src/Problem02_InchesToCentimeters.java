import java.util.Scanner;

public class Problem02_InchesToCentimeters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("inches = ");
        double inches = Double.parseDouble(scan.nextLine());
        double centimeters = inches * 2.54;
        System.out.println("centimeters = " + centimeters);
    }
}
