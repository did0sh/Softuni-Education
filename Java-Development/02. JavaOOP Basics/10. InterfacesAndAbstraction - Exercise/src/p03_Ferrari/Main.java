package p03_Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();

        Drivable drivable = new Ferrari(name);
        System.out.println(drivable);
    }
}
