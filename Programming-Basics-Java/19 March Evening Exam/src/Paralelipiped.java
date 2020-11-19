import java.util.Scanner;

public class Paralelipiped {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int width = 3*num+1;

        System.out.printf("+%s+%s%n",
                repeatStr("~", num -2),
                repeatStr(".", (width)-2-(num-2)));

        for (int i = 0; i <= num*2 ; i++) {
            System.out.printf("|%s\\%s\\%s%n",
                    repeatStr(".", i),
                    repeatStr("~", num - 2),
                    repeatStr(".", width-3-(num-2)-i));
        }

        for (int i = 0; i <= num*2; i++) {
            System.out.printf("%s\\%s|%s|%n",
                    repeatStr(".", i),
                    repeatStr(".", width-3-(num-2)-i),
                    repeatStr("~", num - 2));
        }

        System.out.printf("%s+%s+",
                repeatStr(".", width - 2 - (num-2)),
                repeatStr("~", num-2));
    }
    private  static String repeatStr (String symbol, int count){
        String result = "";

        for (int i = 0; i < count; i++) {
            result += symbol;
        }
        return result;
    }
}
