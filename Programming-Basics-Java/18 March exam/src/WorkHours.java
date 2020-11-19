import java.util.Scanner;

public class WorkHours {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hoursNeeded = Integer.parseInt(scan.nextLine());
        int numberOfWorkers = Integer.parseInt(scan.nextLine());
        int days = Integer.parseInt(scan.nextLine());

        int workTime = numberOfWorkers * days * 8;
        int diff = Math.abs(hoursNeeded - workTime);

        if (workTime >= hoursNeeded){
            System.out.printf("%d hours left", diff);
        } else {
            System.out.printf("%d overtime%n", diff);
            int penalties = diff * days;
            System.out.printf("Penalties: %d", penalties);
        }
    }
}
