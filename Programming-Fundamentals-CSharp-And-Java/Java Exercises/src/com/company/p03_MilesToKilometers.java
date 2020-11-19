package com.company;

import java.util.Scanner;

/**
 * Created by user on 20.9.2017 г..
 */
public class p03_MilesToKilometers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double miles = Double.parseDouble(scan.nextLine());
        double kilometers = miles * 1.60934;

        System.out.printf("%.2f", kilometers);
    }
}
