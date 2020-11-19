import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by user on 1.10.2017 г..
 */
public class p11_ConvertSpeedUnits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);



        float distanceInMeters = Float.parseFloat(scan.nextLine());
        float hours = Float.parseFloat(scan.nextLine());
        float minutes = Float.parseFloat(scan.nextLine());
        float seconds = Float.parseFloat(scan.nextLine());


        float hourTime = (hours + minutes/60 + seconds/3600);


        float kilometerSpeedPerHours = distanceInMeters / 1000 / hourTime;
        float meterSpeedPerSeconds = kilometerSpeedPerHours * 1000 / 3600;
        float milesSpeedPerHours = distanceInMeters / 1609 / hourTime;

        System.out.println(meterSpeedPerSeconds);
        System.out.println(kilometerSpeedPerHours);
        System.out.println(milesSpeedPerHours);


    }
}
