import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String season = scan.nextLine();
        String group = scan.nextLine();
        int numberOfStudents = Integer.parseInt(scan.nextLine());
        int nights = Integer.parseInt(scan.nextLine());

        double priceForANight = 1;


        if (season.equals("Winter") && (group.equals("girls") || group.equals("boys"))) {
            priceForANight = 9.60;
        } else if (season.equals("Spring") && (group.equals("girls") || group.equals("boys"))) {
            priceForANight = 7.20;
        } else if (season.equals("Summer") && (group.equals("girls") || group.equals("boys"))) {
            priceForANight = 15;
        } else if (season.equals("Winter") && group.equals("mixed")) {
            priceForANight = 10;
        } else if (season.equals("Spring") && group.equals("mixed")) {
            priceForANight = 9.50;
        } else if (season.equals("Summer") && group.equals("mixed")) {
            priceForANight = 20;
        }

        if (season.equals("Winter") && group.equals("girls")) {
            System.out.print("Gymnastics ");
        } else if (season.equals("Spring") && group.equals("girls")) {
            System.out.print("Athletics ");
        } else if (season.equals("Summer") && group.equals("girls")) {
            System.out.print("Volleyball ");

        } else if (season.equals("Winter") && group.equals("boys")) {
            System.out.print("Judo ");
        } else if (season.equals("Spring") && group.equals("boys")) {
            System.out.print("Tennis ");
        } else if (season.equals("Summer") && group.equals("boys")) {
            System.out.print("Football ");

        } else if (season.equals("Winter") && group.equals("mixed")) {
            System.out.print("Ski ");
        } else if (season.equals("Spring") && group.equals("mixed")) {
            System.out.print("Cycling ");
        } else if (season.equals("Summer") && group.equals("mixed")) {
            System.out.print("Swimming ");
        }

        if (numberOfStudents >= 50) {
            double sum = numberOfStudents * nights * priceForANight;
            double result = sum - 0.5 * sum;
            System.out.printf("%.2f lv.", result);
        } else if (numberOfStudents >= 20 && numberOfStudents < 50) {
            double sum = numberOfStudents * nights * priceForANight;
            double result = sum - 0.15 * sum;
            System.out.printf("%.2f lv.", result);
        }else if (numberOfStudents >= 10 && numberOfStudents < 20) {
            double sum = numberOfStudents * nights * priceForANight;
            double result = sum - 0.05 * sum;
            System.out.printf("%.2f lv.", result);
        } else {
            double sum = numberOfStudents * nights * priceForANight;
            System.out.printf("%.2f lv.", sum);
        }

    }
}