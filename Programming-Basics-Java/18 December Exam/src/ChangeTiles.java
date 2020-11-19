import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.util.Scanner;

public class ChangeTiles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        double widthFloor = Double.parseDouble(scan.nextLine());
        double lengthFloor = Double.parseDouble(scan.nextLine());
        double sideTriangle = Double.parseDouble(scan.nextLine());
        double heightTriangle = Double.parseDouble(scan.nextLine());
        double priceTile = Double.parseDouble(scan.nextLine());
        double priceMeister = Double.parseDouble(scan.nextLine());


        double floorArea = widthFloor * lengthFloor;
        double tileArea = (sideTriangle * heightTriangle)/2;

        double tilesNeeded = Math.ceil(floorArea/tileArea) + 5;


        double sum = tilesNeeded*priceTile + priceMeister;
        double diff = Math.abs(sum-budget);

        if (sum <= budget){
            System.out.printf("%.2f lv left.", diff);
        } else {
            System.out.printf("You'll need %.2f lv more.", diff);
        }

    }
}
