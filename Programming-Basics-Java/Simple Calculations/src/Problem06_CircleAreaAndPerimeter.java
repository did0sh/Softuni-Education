import java.util.Scanner;

public class Problem06_CircleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double radius = Double.parseDouble(scan.nextLine());
        double area = Math.PI * Math.pow(radius, 2);
        double perimeter = 2 * Math.PI * radius;
        System.out.println(area);
        System.out.println(perimeter);
    }
}
