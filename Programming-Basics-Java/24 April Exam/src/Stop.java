import java.util.Scanner;

public class Stop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        System.out.printf("%s%s%s%n",
                repeatStr(".", num+1),
                repeatStr("_", (num*4+3)-2*(num+1)),
                repeatStr(".", num+1));

        for (int i = 0; i < num ; i++) {
            System.out.printf("%s//%s\\\\%s%n",
                    repeatStr(".", num-i),
                    repeatStr("_", (num*4+3)-4-2*(num-i)),
                    repeatStr(".", num-i));
        }

        System.out.printf("//%sSTOP!%s\\\\%n",
                repeatStr("_", ((num*4+3)-9)/2),
                repeatStr("_", ((num*4+3)-9)/2));

        for (int i = 0; i < num ; i++) {
            System.out.printf("%s\\\\%s//%s%n",
                    repeatStr(".", i),
                    repeatStr("_", (num*4+3)-4-2*i),
                    repeatStr(".", i));
        }

    }

    private static String repeatStr (String symbol, int count){
        String result = "";

        for (int i = 0; i < count; i++) {
            result += symbol;
        }
        return result;
    }
}
