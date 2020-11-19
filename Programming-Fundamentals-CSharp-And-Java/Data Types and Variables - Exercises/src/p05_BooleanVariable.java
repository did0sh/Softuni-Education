import java.util.Scanner;

/**
 * Created by user on 30.9.2017 г..
 */
public class p05_BooleanVariable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        if (input.equals("True")){
            System.out.println("Yes");
        } else if (input.equals("False")){
            System.out.println("No");
        }

    }
}
