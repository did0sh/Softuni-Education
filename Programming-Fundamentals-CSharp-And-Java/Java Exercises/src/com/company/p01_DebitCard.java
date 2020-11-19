package com.company;

import java.util.Scanner;

/**
 * Created by user on 20.9.2017 г..
 */
public class p01_DebitCard {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());
        int d = Integer.parseInt(scan.nextLine());

        System.out.printf("%04d %04d %04d %04d ", a,b,c,d);

    }
}
