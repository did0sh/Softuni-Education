import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by user on 3.10.2017 г..
 */
public class p07_MathPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("#.########");

        double num = Double.parseDouble(scan.nextLine());
        int power = Integer.parseInt(scan.nextLine());
        double result = powerOfNum(num, power);
        System.out.println(df.format(result));
    }

    static double powerOfNum (double num, int power){

        double result = Math.pow(num,power);
        return result;
    }
}
