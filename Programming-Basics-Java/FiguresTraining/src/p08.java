import java.util.Scanner;

public class p08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        System.out.printf("%s%s%s%n"
                ,repeatStr("*", num * 2),
                repeatStr(" ", num),
                repeatStr("*", num * 2));

        for (int i = 1; i <= num - 2; i++) {
            if (i == (num-1)/2) {
                System.out.printf("*%s*%s*%s*%n",
                        repeatStr("/", num*2-2),
                        repeatStr("|", num),
                        repeatStr("/", num*2-2));
            } else {
                System.out.printf("*%s*%s*%s*%n",
                        repeatStr("/", num*2-2),
                        repeatStr(" ", num),
                        repeatStr("/", num*2-2));
            }

        }

        System.out.printf("%s%s%s%n"
                ,repeatStr("*", num * 2),
                repeatStr(" ", num),
                repeatStr("*", num * 2));
    }
    private static String repeatStr(String symbol, int count){
        String result = "";

        for (int i = 0; i < count; i++) {
            result += symbol;
        }
        return result;

    }
}
