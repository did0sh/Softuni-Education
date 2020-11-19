import java.util.Scanner;

public class p15_CensorEmailAddress {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String email = scan.nextLine();

        String[] tokens = email.split("@");
        String username = tokens[0];
        String domein = tokens[1];

        String input = scan.nextLine();

        StringBuilder replacement = new StringBuilder();

        for (int i = 0; i < username.length(); i++) {
            replacement.append("*");
        }

        replacement.append("@");
        replacement.append(domein);

        input = input.replaceAll(email, replacement.toString());

        System.out.println(input);
    }
}
