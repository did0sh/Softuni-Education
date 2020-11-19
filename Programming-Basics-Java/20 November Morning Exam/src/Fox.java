import java.util.Scanner;

public class Fox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= num ; i++) {
            System.out.printf("%s\\%s/%s%n", repeatStr("*", i),
                    repeatStr("-", (2*num+3)-2-2*i),
                    repeatStr("*", i));
        }


        for (int i = 0; i < num/3 ; i++) {
            System.out.printf("|%s\\%s/%s|%n", repeatStr("*", num/2 + i),
                    repeatStr("*",(2*num+3)-4-2*(num/2 + i)),
                    repeatStr("*", num/2 + i));
        }


        for (int i = 1; i <= num ; i++) {
            System.out.printf("%s\\%s/%s%n", repeatStr("-", i),
                    repeatStr("*", (2*num+3)-2-2*i),
                    repeatStr("-", i));
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
