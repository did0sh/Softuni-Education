import java.util.Scanner;

public class Sunglasses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        System.out.printf("%s%s%s%n", repeatStr("*", number*2),
                repeatStr(" ", number),
                repeatStr("*", number*2));

        for (int i = 0; i < number - 2 ; i++) {
            if (i == (number - 1)/2 - 1) {
                System.out.printf("*%s*%s*%s*%n",repeatStr("/", number*2 - 2),
                        repeatStr("|", number),
                        repeatStr("/", number*2 - 2));
            } else {
                System.out.printf("*%s*%s*%s*%n",repeatStr("/", number*2 - 2),
                        repeatStr(" ", number),
                        repeatStr("/", number*2 - 2));
            }

        }

        System.out.printf("%s%s%s%n", repeatStr("*", number*2),
                repeatStr(" ", number),
                repeatStr("*", number*2));
    }
    public static String repeatStr (String symbol , int count){
        String result = "";

        for (int j = 0; j < count ; j++) {
            result += symbol;
        }
        return result;
    }
}
