import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int oldPeople = Integer.parseInt(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        int nights = Integer.parseInt(scan.nextLine());
        String transportType = scan.nextLine();

        double sumOldPeople = 0.0;
        double sumStudents = 0.0;

        if (transportType.equals("train")){

            if (( oldPeople + students) >= 50){
                sumOldPeople = 24.99 - 0.5*24.99;
                sumStudents = 14.99 - 0.5*14.99;
            } else {
                sumOldPeople = 24.99;
                sumStudents = 14.99;
            }

        } else if (transportType.equals("bus")){
            sumOldPeople = 32.50;
            sumStudents = 28.50;
        } else if (transportType.equals("boat")){
            sumOldPeople = 42.99;
            sumStudents = 39.99;
        } else if (transportType.equals("airplane")){
            sumOldPeople = 70.00;
            sumStudents = 50.00;
        }

        double totalRazhod = (oldPeople * sumOldPeople + students * sumStudents)*2;
        double hotel = nights * 82.99;
        double commission = (totalRazhod + hotel)*0.1;

        double totalSum = totalRazhod + hotel + commission;



        System.out.printf("%.2f", totalSum);
    }
}
