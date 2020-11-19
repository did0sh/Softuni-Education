import java.util.Scanner;

public class RectangleOfNxNStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n ; i++) {
            System.out.print(repeatStr("*", n));
            System.out.println();
        }


    }
    private static String repeatStr (String symbol, int count){
        String result = "";

        for (int j = 0; j < count; j++){
            result += symbol;
        }
        return result;
    }
}
