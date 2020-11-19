import java.util.Scanner;

public class p02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < num ; i++) {
            System.out.printf("%s%n", repeatStr("*", num));
        }
    }
    private static String repeatStr (String symbol, int count){
        String result = "";

        for (int i = 0; i < count ; i++) {
            result += symbol;
        }
        return result;
    }
}
