import java.util.Scanner;

public class TriangleOfDollars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= num ; i++) {
            System.out.printf("%s%n", repeatStr("$ ", i));
        }
    }
    private static String repeatStr (String symbol, int count){
        String result = "";

        for (int j = 0; j < count ; j++) {
            result += symbol;
        }
        return result;
    }
}
