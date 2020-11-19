import java.util.Scanner;

/**
 * Created by user on 30.9.2017 г..
 */
public class p04_VariableInHexadecimalFormat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String reminder = scan.nextLine();

        System.out.println(Integer.parseInt(reminder.substring(2), 16));
    }
}
