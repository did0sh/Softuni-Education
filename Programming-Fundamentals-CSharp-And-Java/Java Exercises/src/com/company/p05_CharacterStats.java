package com.company;

        import java.util.Scanner;

/**
 * Created by user on 20.9.2017 г..
 */
public class p05_CharacterStats {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        int currentHealth = Integer.parseInt(scan.nextLine());
        int maximumHealth = Integer.parseInt(scan.nextLine());
        int currentEnergy = Integer.parseInt(scan.nextLine());
        int maximumEnergy = Integer.parseInt(scan.nextLine());

        int healthLeft = maximumHealth - currentHealth;
        int energyLeft = maximumEnergy - currentEnergy;

        System.out.printf("Name: %s%n", name);
        System.out.printf("Health: |%s%s|%n", repeatStr('|',currentHealth), repeatStr('.', healthLeft));
        System.out.printf("Energy: |%s%s|%n", repeatStr('|', currentEnergy), repeatStr('.', energyLeft));



    }
    private static String repeatStr (char symbol, int count){
        String result = "";

        for (int i = 0; i < count; i++) {
            result += symbol;
        }
        return result;

    }
}
