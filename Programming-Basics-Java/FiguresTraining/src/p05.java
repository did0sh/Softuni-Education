import java.util.Scanner;

public class p05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        System.out.printf("+ %s+%n",repeatStr("- ", num - 2));

        for (int i = 0; i < num - 2; i++) {
            System.out.printf("| %s|%n",repeatStr("- ", num - 2));
        }

        System.out.printf("+ %s+%n",repeatStr("- ", num - 2));
    }
    private static String repeatStr (String symbol, int count){
        String result = "";

        for (int i = 0; i < count; i++) {
            result += symbol;
        }
        return result;
    }
}
