import java.util.Scanner;

public class Problem08_TriangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = Double.parseDouble(scan.nextLine());
        double h = Double.parseDouble(scan.nextLine());
        double area = (a * h) / 2;
        System.out.printf("Triangle area = %.2f", area);
    }
}
