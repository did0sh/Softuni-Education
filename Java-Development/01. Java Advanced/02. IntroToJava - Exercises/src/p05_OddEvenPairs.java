import java.util.Scanner;

public class p05_OddEvenPairs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String[] arguments = input.split("\\s");
        if (arguments.length % 2 != 0){
            System.out.println("invalid length");
            return;
        }

        for (int i = 0; i < arguments.length; i+=2) {
            int current = Integer.parseInt(arguments[i]);
            int next = Integer.parseInt(arguments[i+1]);

            if (current % 2 == 0 && next % 2 == 0){
                System.out.printf("%d, %d -> both are even%n", current, next);
            } else if (current % 2 != 0 && next % 2 != 0){
                System.out.printf("%d, %d -> both are odd%n", current, next);
            } else {
                System.out.printf("%d, %d -> different%n", current, next);
            }
        }
    }
}
