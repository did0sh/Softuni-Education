import java.util.Scanner;

public class p01_RectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double area = a * b;
        System.out.printf("%.2f", area);
    }
}
