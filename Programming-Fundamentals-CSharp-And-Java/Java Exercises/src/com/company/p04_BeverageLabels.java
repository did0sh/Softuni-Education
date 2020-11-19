package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by user on 20.9.2017 г..
 */
public class p04_BeverageLabels {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("#.####");

        String name = scan.nextLine();
        int volume = Integer.parseInt(scan.nextLine());
        double energy = Double.parseDouble(scan.nextLine());
        double sugars = Double.parseDouble(scan.nextLine());

        double allVolume = volume/100.00;

        energy *= allVolume;
        sugars *= allVolume;

        System.out.printf("%dml %s:%n", volume, name);
        System.out.println(String.format("%skcal, %sg sugars", df.format(energy), df.format(sugars)));
    }
}
