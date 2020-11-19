import java.util.Scanner;

public class Hourglass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        System.out.printf("%s%n", repeatStr("*", num*2 + 1));
        System.out.printf(".*%s*.%n",repeatStr(" ", (num*2+1)-4));

        for (int i = 2; i < num ; i++) {
            System.out.printf("%s*%s*%s%n",
                    repeatStr(".", i),
                    repeatStr("@", (num*2+1)-2-2*i),
                    repeatStr(".", i));
        }

        System.out.printf("%s*%s%n", repeatStr(".", num),
                repeatStr(".", num));

        for (int i = 1; i <= num - 2 ; i++) {
            System.out.printf("%s*%s@%s*%s%n",
                    repeatStr(".", num - i),
                    repeatStr(" ", i - 1),
                    repeatStr(" ", i - 1),
                    repeatStr(".", num - i));
        }

        System.out.printf(".*%s*.%n",repeatStr("@", (num*2+1)-4));
        System.out.printf("%s%n", repeatStr("*", num*2 + 1));
    }
    private static String repeatStr (String symbol, int count){
        String result="";

        for (int i = 0; i < count; i++) {
            result += symbol;
        }
        return result;
    }
}
