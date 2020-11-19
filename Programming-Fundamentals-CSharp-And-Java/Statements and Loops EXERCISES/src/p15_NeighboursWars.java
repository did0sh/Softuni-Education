import java.util.Scanner;

/**
 * Created by user on 24.9.2017 г..
 */
public class p15_NeighboursWars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int peshoDamaage = Integer.parseInt(scan.nextLine());
        int goshoDamage = Integer.parseInt(scan.nextLine());
        int roundCount = 0;

        int peshoHealth = 100;
        int goshoHealth = 100;

        while (peshoHealth > 0 || goshoHealth > 0){

            roundCount++;

            if (roundCount %2 == 0){      // even rounds (2,4,6,8 ..)
                peshoHealth -= goshoDamage;
                if (peshoHealth <= 0) {
                    System.out.printf("Gosho won in %dth round.%n", roundCount);
                    return;
                } else {
                    System.out.printf("Gosho used Thunderous fist and reduced Pesho to %d health.%n", peshoHealth );
                }


            } else if (roundCount %2 != 0){   // even rounds (1,3,5,7 ..)
                goshoHealth -= peshoDamaage;
                if (goshoHealth <= 0){
                    System.out.printf("Pesho won in %dth round.%n", roundCount);
                    return;
                } else {
                    System.out.printf("Pesho used Roundhouse kick and reduced Gosho to %d health.%n", goshoHealth );
                }
            }

            if (roundCount % 3 == 0){   // every third round (3,6,9 ..)
                peshoHealth += 10;
                goshoHealth += 10;

            }

        }
    }
}
