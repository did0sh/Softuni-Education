import java.util.Scanner;

public class Battles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstPlayerPokemons = Integer.parseInt(scan.nextLine());
        int secondPlayerPokemons = Integer.parseInt(scan.nextLine());
        int maxFights = Integer.parseInt(scan.nextLine());

        int fightsCount = 0;


        for (int i = 1; i <= firstPlayerPokemons ; i++) {
            for (int j = 1; j <= secondPlayerPokemons ; j++) {
                   fightsCount++;

                   if (fightsCount != maxFights){
                       System.out.printf("(%d <-> %d) ", i, j);
                   }

                if (fightsCount == maxFights){
                    System.out.printf("(%d <-> %d) ", i, j);
                       return;
                }
            }
        }

    }
}
