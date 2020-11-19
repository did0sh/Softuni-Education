import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by user on 2.10.2017 г..
 */
public class p04_TouristInformation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("#.######");
        String type = scan.nextLine();
        double number = Double.parseDouble(scan.nextLine());
        String convert = "";
        double reminder = number;

        if (type.equals("miles")){
            number *= 1.6;
            convert = "kilometers";
        } else if (type.equals("inches")) {
            number *= 2.54;
            convert = "centimeters";
        } else if (type.equals("feet")){
            number *= 30;
            convert = "centimeters";
        } else if (type.equals("yards")){
            number *= 0.91;
            convert = "meters";
        } else if (type.equals("gallons")) {
            number *= 3.8;
            convert = "liters";
        }

        System.out.printf("%s %s = %.2f %s", df.format(reminder), type, number, convert);

    }
}
