import java.util.Scanner;

public class Problem02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        double recordInSeconds = Double.parseDouble(scan.nextLine());
        double lengthInMeters = Double.parseDouble(scan.nextLine());
        double secondsFor1Meter = Double.parseDouble(scan.nextLine());

        double swimmingTime = lengthInMeters * secondsFor1Meter;
        double slowTime = Math.floor((lengthInMeters/15))*12.5;

        double totalTime = slowTime + swimmingTime;

        if (totalTime >= recordInSeconds){
            double diff = totalTime - recordInSeconds;
            System.out.printf("No, he failed! He was %.2f seconds slower.", diff);
        } else {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalTime);
        }
    }
}
