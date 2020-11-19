import java.util.Scanner;

/**
 * Created by user on 29.9.2017 г..
 */
public class p02_CircleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double radius = Double.parseDouble(scan.nextLine());

        System.out.printf("%.12f", Math.PI * radius * radius);
    }
}
