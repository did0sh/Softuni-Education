import java.util.Scanner;

public class Problem07_RectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x1 = Double.parseDouble(scan.nextLine());
        double y1 = Double.parseDouble(scan.nextLine());
        double x2 = Double.parseDouble(scan.nextLine());
        double y2 = Double.parseDouble(scan.nextLine());

        double sideA = Math.abs(x1-x2);
        double sideB = Math.abs(y1-y2);

        double perimeter = (sideA+sideB) * 2;
        double area = sideA*sideB;

        System.out.println(area);
        System.out.println(perimeter);

    }
}
