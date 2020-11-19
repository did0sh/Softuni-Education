import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by user on 25.9.2017 г..
 */
public class p03_Megapixels {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("#.#");

        int width = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());

        double megapixels = (width * height)/ 1000000.00;

        System.out.println(String.format("%dx%d => %sMP", width, height, df.format(megapixels)));
    }
}
