import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= number ; i++) {
            System.out.printf("%s%s%n",repeatStr(" ", number - i), repeatStr("* ", i).trim());
        }

        for (int j = number - 1; j > 0 ; j--) {
            System.out.printf("%s%s%n", repeatStr(" ", number - j), repeatStr("* ", j).trim());
        }
    }
    private static String repeatStr (String symbol , int count){
        String result = "";

        for (int j = 0; j < count ; j++) {
            result += symbol;
        }
        return result;
    }
}
