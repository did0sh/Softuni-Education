import java.util.Scanner;

public class p03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < num; i++) {
            System.out.printf("%s%n",repeatStr("* ", num).trim());
        }
    }
    private static String repeatStr(String symbol, int count){
        String result = "";

        for (int i = 0; i < count ; i++) {
            result += symbol;
        }
        return result;
    }
}
