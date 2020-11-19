import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by user on 3.10.2017 г..
 */
public class p06_CalculateTriangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("#.########");

        double base = Double.parseDouble(scan.nextLine());
        double height = Double.parseDouble(scan.nextLine());
        double area = getTriangleArea(base,height);

        System.out.println(df.format(area));

    }

    static double getTriangleArea (double base, double height){

        return (base*height)/2;
    }
}
