import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by user on 25.9.2017 г..
 */
public class p04_PhotoGallery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int photoNumber = Integer.parseInt(scan.nextLine());
        int day = Integer.parseInt(scan.nextLine());
        int month = Integer.parseInt(scan.nextLine());
        int year = Integer.parseInt(scan.nextLine());
        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());
        double bytes = Double.parseDouble(scan.nextLine());
        int resolutionWidth = Integer.parseInt(scan.nextLine());
        int resolutionHeight = Integer.parseInt(scan.nextLine());

        DecimalFormat df = new DecimalFormat("#.#");

        System.out.printf("Name: DSC_%04d.jpg%n", photoNumber);
        System.out.printf("Date Taken: %02d/%02d/%d %02d:%02d%n", day, month, year, hours, minutes);

        if (bytes < 1000){
            System.out.printf("Size: %.0fB%n", bytes);
        } else if (bytes >= 1000 && bytes < 1000000){
            bytes /= 1000;
            System.out.println(String.format("Size: %sKB", df.format(bytes)));
        } else if (bytes >= 1000000) {
            bytes /= 1000000;
            System.out.println(String.format("Size: %sMB", df.format(bytes)));
        }


        if (resolutionHeight == resolutionWidth){
            System.out.printf("Resolution: %dx%d (square)", resolutionWidth ,resolutionHeight);
        } else if (resolutionWidth > resolutionHeight){
            System.out.printf("Resolution: %dx%d (landscape)", resolutionWidth, resolutionHeight);
        } else if (resolutionWidth < resolutionHeight){
            System.out.printf("Resolution: %dx%d (portrait)", resolutionWidth, resolutionHeight);
        }


    }
}
