import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by user on 1.10.2017 г..
 */
public class p12_RectangleProperties {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("#.#############");

        double width = Double.parseDouble(scan.nextLine());
        double height = Double.parseDouble(scan.nextLine());

        double perimeter = 2*(width + height);
        double area = width * height;
        double diagonal = Math.sqrt(width*width + height*height);

        System.out.println(df.format(perimeter));
        System.out.println(df.format(area));
        System.out.println(df.format(diagonal));
    }
}
