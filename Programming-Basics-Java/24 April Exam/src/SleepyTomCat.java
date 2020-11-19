import java.util.Scanner;

public class SleepyTomCat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int breakDays = Integer.parseInt(scan.nextLine());
        int minutesPlayOnBreak = 127;
        int minutesPlayOnWork = 63;
        int daysInAYear = 365;

        int workDays = daysInAYear - breakDays;
        int playTime = workDays * minutesPlayOnWork + breakDays * minutesPlayOnBreak;

        int difference = Math.abs(30000 - playTime);

        if (playTime < 30000){
            System.out.println("Tom sleeps well");
            int hoursLeft = difference / 60;
            int minutesLeft = difference % 60;
            System.out.printf("%d hours and %d minutes less for play", hoursLeft, minutesLeft);
        } else if (playTime > 30000){
            System.out.println("Tom will run away");
            int hoursLeft = difference / 60;
            int minutesLeft = difference % 60;
            System.out.printf("%d hours and %d minutes more for play", hoursLeft, minutesLeft);
        }
    }
}
