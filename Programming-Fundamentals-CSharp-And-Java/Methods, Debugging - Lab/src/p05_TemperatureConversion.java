import java.util.Scanner;

/**
 * Created by user on 3.10.2017 г..
 */
public class p05_TemperatureConversion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double fahrenheit = Double.parseDouble(scan.nextLine());
        double celsius = fromFahrenheitToCelsius(fahrenheit);
        System.out.printf("%.2f", celsius);
    }

    static double fromFahrenheitToCelsius(double fahrenheit){

        return (fahrenheit -32)*5/9;
    }
}
