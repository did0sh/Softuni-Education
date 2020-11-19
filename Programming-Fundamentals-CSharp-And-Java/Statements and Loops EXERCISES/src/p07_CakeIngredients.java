import java.util.Scanner;

/**
 * Created by user on 23.9.2017 г..
 */
public class p07_CakeIngredients {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String ingredient = scan.nextLine();
        int ingredientCount = 0;

        while (!ingredient.equals("Bake!")){
            System.out.println(String.format("Adding ingredient %s.", ingredient));
            ingredientCount++;
            ingredient = scan.nextLine();
        }

        System.out.printf("Preparing cake with %d ingredients.", ingredientCount);
    }
}
