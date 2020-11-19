import java.util.Scanner;

/**
 * Created by user on 23.9.2017 г..
 */
public class p05_WordInPlural {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        if (input.endsWith("y")){
            input = input.substring(0, input.length() - 1);
            input += "ies";


        } else  if (input.endsWith("o") || input.endsWith("ch") ||
                input.endsWith("s") || input.endsWith("sh")
                || input.endsWith("x") || input.endsWith("z")) {

            input += "es";

        } else {

            input += "s";
        }

        System.out.println(input);

    }
}
