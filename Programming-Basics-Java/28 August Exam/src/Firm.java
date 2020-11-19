import java.util.Scanner;

public class Firm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hoursNeeded = Integer.parseInt(scan.nextLine());
        int days = Integer.parseInt(scan.nextLine());
        int workers = Integer.parseInt(scan.nextLine());

        double leftHours = (days - 0.1*days)*8;
        int workersHours = workers*2*days;
        double amountOfHours = Math.floor(leftHours + workersHours);

        int difference = Math.abs((int)amountOfHours - hoursNeeded);

        if (amountOfHours >= hoursNeeded){
            System.out.printf("Yes!%d hours left.", difference);
        } else {
            System.out.printf("Not enough time!%d hours needed.", difference);
        }


    }
}
