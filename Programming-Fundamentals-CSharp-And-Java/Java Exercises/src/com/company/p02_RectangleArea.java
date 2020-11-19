package com.company;

import java.util.Scanner;

/**
 * Created by user on 20.9.2017 г..
 */
public class p02_RectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double a = Double.parseDouble(scan.nextLine());
        double ha = Double.parseDouble(scan.nextLine());

        double area = a*ha;

        System.out.printf("%.2f", area);
    }
}
