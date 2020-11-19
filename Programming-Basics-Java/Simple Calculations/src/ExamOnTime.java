import java.util.Scanner;

public class ExamOnTime {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int examHours = Integer.parseInt(console.nextLine());
        int examMinutes = Integer.parseInt(console.nextLine());
        int comeHours = Integer.parseInt(console.nextLine());
        int comeMinutes = Integer.parseInt(console.nextLine());

        int examTime = examHours * 60 + examMinutes;
        int comeTime = comeHours * 60 + comeMinutes;
        int minutesDifference = Math.abs(comeTime - examTime);

        if (examTime < comeTime) {
            System.out.println("Late");
            if (minutesDifference < 60) {
                System.out.printf("%d minutes after the start", minutesDifference);
            } else {
                int hours = minutesDifference / 60;
                int minutes = minutesDifference % 60;
                System.out.printf("%d:%02d hours after the start", hours, minutes);
            }
        } else if (minutesDifference == 0 || minutesDifference <= 30) {
            System.out.println("On time");
            if (minutesDifference != 0) {
                System.out.printf("%d minutes before the start", minutesDifference);
            }
        } else {
            System.out.println("Early");
            if (minutesDifference < 60) {
                System.out.printf("%d minutes before the start", minutesDifference);
            } else {
                int hours = minutesDifference / 60;
                int minutes = minutesDifference % 60;
                System.out.printf("%d:%02d hours before the start", hours, minutes);
            }
        }
    }
}