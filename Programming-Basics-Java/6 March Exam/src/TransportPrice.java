import java.text.DecimalFormat;
import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfKilometers = Integer.parseInt(scan.nextLine());
        String dayOrNight = scan.nextLine();

        DecimalFormat df = new DecimalFormat("#.##");

        if (numberOfKilometers < 20){
            if (dayOrNight.equals("day")){
                System.out.println(df.format(0.70 + numberOfKilometers*0.79));
            } else if (dayOrNight.equals("night")){
                System.out.println(df.format(0.70 + numberOfKilometers*0.90));
            }
        }

        if (numberOfKilometers >= 20 && numberOfKilometers < 100){
            System.out.println(df.format(numberOfKilometers*0.09));
        }

        if (numberOfKilometers >= 100){
            System.out.println(df.format(numberOfKilometers*0.06));
        }

    }
}
