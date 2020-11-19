import java.util.Scanner;

public class SquareFrame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

       //top part
            System.out.printf("+ %s+%n", repeatStr("- ", num - 2));

// middle
        for (int i = 1; i <= num - 2 ; i++) {
            System.out.printf("| %s|%n", repeatStr("- ", num - 2));
        }
        // bottom
        System.out.printf("+ %s+%n", repeatStr("- ", num - 2));

    }
    private static String repeatStr (String symbol, int count){
        String result = "";

        for (int j = 0; j < count ; j++) {
            result += symbol;
        }
        return result;
    }
}
