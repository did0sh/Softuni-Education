import java.util.Scanner;

public class p14_FitStringIn20Chars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        StringBuilder stringBuilder = new StringBuilder();

        if (input.length() > 20) {
            System.out.println(input.substring(0, 20));
        } else if (input.length() < 20) {

            stringBuilder.append(input);
            for (int i = 0; i < 20 - input.length(); i++) {
                stringBuilder.append('*');

            }
            System.out.println(stringBuilder);
        }
    }
}
