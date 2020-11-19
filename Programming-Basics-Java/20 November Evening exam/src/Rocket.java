import java.util.Scanner;

public class Rocket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < num ; i++) {
            System.out.printf("%s/%s\\%s%n",
                    repeatStr(".", (3*num - 2 - 2*i)/2),
                    repeatStr(" ", 2*i),
                    repeatStr(".",(3*num - 2 - 2*i)/2));
        }

        System.out.printf("%s%s%s%n",
                repeatStr(".", num/2),
                repeatStr("*", num*2),
                repeatStr(".", num/2));

        for (int i = 0; i < num*2 ; i++) {
            System.out.printf("%s|%s|%s%n",
                    repeatStr(".", num/2),
                    repeatStr("\\", 2*num - 2),
                    repeatStr(".", num/2));
        }

        for (int i = num/2; i >= 1 ; i--) {
            System.out.printf("%s/%s\\%s%n",
                    repeatStr(".", i),
                    repeatStr("*", 3*num-2-2*i),
                    repeatStr(".", i));
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
