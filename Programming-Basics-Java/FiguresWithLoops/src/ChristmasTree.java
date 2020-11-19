import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        System.out.printf("%s|%s%n", repeatStr(" ", number + 1), repeatStr(" ", number + 1));

        for (int i = 1; i <= number ; i++) {
            System.out.printf("%s%s | %s%s%n",repeatStr(" ", number - i),
                    repeatStr("*", i),
                    repeatStr("*", i),
                    repeatStr(" ", number - i));
        }

    }

    public static String repeatStr (String symbol , int count){
        String result = "";

        for (int i = 0; i < count ; i++) {
            result += symbol;
        }
        return result;
    }
}
