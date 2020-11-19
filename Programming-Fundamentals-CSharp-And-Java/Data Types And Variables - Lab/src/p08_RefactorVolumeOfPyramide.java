import java.util.Scanner;

/**
 * Created by user on 29.9.2017 г..
 */
public class p08_RefactorVolumeOfPyramide {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double length = Double.parseDouble(scan.nextLine());
        double width = Double.parseDouble(scan.nextLine());
        double heigth = Double.parseDouble(scan.nextLine());
        double volume = 0;


        System.out.printf("Length: ");

        System.out.printf("Width: ");

        System.out.printf("Height: ");

        volume = (length * width * heigth) / 3;
        System.out.printf("Pyramid Volume: %.2f", volume);

    }
}
