import java.util.Scanner;

public class Problem05_TrapezoidArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double firstBase = Double.parseDouble(scan.nextLine());
        double secondBase = Double.parseDouble(scan.nextLine());
        double height = Double.parseDouble(scan.nextLine());
        double area = (firstBase + secondBase) * height / 2;
        System.out.println("Trapezoid area = " + area);
    }
}
