package p03_Ferrari;

import p03_Ferrari.entities.Ferrari;
import p03_Ferrari.interfaces.Moveable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String driverName = scan.nextLine();

        Moveable ferrari = new Ferrari(driverName);
        System.out.println(ferrari);
    }
}
