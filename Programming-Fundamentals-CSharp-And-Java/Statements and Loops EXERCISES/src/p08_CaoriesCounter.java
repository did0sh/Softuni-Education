import java.util.Scanner;

/**
 * Created by user on 23.9.2017 г..
 */
public class p08_CaoriesCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int calories = 0;

        for (int i = 0; i < n ; i++) {
            String ingredient = scan.nextLine().toLowerCase();

            if (ingredient.equals("cheese")){
                calories += 500;
            } else if (ingredient.equals("tomato sauce")){
                calories += 150;
            } else if (ingredient.equals("salami")){
                calories += 600;
            } else if (ingredient.equals("pepper")){
                calories += 50;
            }
        }

        System.out.printf("Total calories: %d", calories);
    }
}
