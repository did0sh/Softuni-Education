import java.util.Scanner;

public class OnTimeForExam {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int examHours = Integer.parseInt(scan.nextLine());
        int examMinutes = Integer.parseInt(scan.nextLine());
        int arrivalHours = Integer.parseInt(scan.nextLine());
        int arrivalMinutes = Integer.parseInt(scan.nextLine());

        int examHoursPlusMinutes = examHours * 60 + examMinutes;
        int arrivalHoursPlusMinutes = arrivalHours * 60 + arrivalMinutes;
        int difference = Math.abs(arrivalHoursPlusMinutes - examHoursPlusMinutes);

        if (examHoursPlusMinutes < arrivalHoursPlusMinutes){
            if (difference < 60){
                System.out.println("Late");
                System.out.printf("%d minutes after the start", difference);
            } else if (difference >= 60) {
               int hoursLeft = difference / 60;
               int minutesLeft = difference % 60;
                System.out.println("Late");
                System.out.printf("%d:%02d hours after the start", hoursLeft,minutesLeft);

            }
        }

        if (examHoursPlusMinutes > arrivalHoursPlusMinutes){
            if (difference <= 30){
                System.out.println("On time");
                System.out.printf("%d minutes before the start", difference);
            } else if (difference > 30 && difference <60){
                System.out.println("Early");
                System.out.printf("%d minutes before the start", difference);
            } else if (difference >= 60){
                System.out.println("Early");
                int hoursLeft = difference / 60;
                int minutesLeft = difference % 60;
                System.out.printf("%d:%02d hours before the start", hoursLeft,minutesLeft);
            }
        }

        if (examHoursPlusMinutes == arrivalHoursPlusMinutes){
            System.out.println("On time");
        }
    }
}
