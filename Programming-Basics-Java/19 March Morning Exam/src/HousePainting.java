import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double x = Double.parseDouble(scan.nextLine());
        double y = Double.parseDouble(scan.nextLine());
        double h = Double.parseDouble(scan.nextLine());

        double windows = 1.5*1.5;
        double sides = (2 * x * y) - 2*windows;
        double entrance = 1.2*2;
        double frontAndBack = 2*x*x - entrance;

        double sumGreen = sides + frontAndBack;
        double greenPaint = sumGreen / 3.4;

        System.out.printf("%.2f%n",greenPaint);

        double roofRectangles = 2*x*y;
        double roofTriangles = 2*((x*h)/2);
        double sumRed = roofRectangles + roofTriangles;
        double redPaint = sumRed / 4.3;

        System.out.printf("%.2f", redPaint);


    }
}
