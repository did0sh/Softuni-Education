import java.util.Scanner;

public class Distance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int speed = Integer.parseInt(scan.nextLine());
        int firstTime = Integer.parseInt(scan.nextLine());
        int secondTime = Integer.parseInt(scan.nextLine());
        int thirdTime = Integer.parseInt(scan.nextLine());

        double hours1 = firstTime / 60.00;
        double hours2 = secondTime / 60.00;
        double hours3 = thirdTime / 60.00;

        double a = speed * hours1;

        double plus10percent = speed + 0.1*speed;
        double b = plus10percent * hours2;

        double c = (plus10percent - 0.05*plus10percent) * hours3;

        double sum = a + b + c;

        System.out.printf("%.2f", sum);

    }
}
