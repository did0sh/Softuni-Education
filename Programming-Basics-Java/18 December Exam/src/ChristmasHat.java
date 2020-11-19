import java.util.Scanner;

public class ChristmasHat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        System.out.printf("%s/|\\%s%n", repeatStr(".", 2*num - 1),
                repeatStr(".", 2*num - 1));

        System.out.printf("%s\\|/%s%n", repeatStr(".", 2*num - 1),
                repeatStr(".", 2*num - 1));

        System.out.printf("%s***%s%n", repeatStr(".", 2*num - 1),
                repeatStr(".", 2*num - 1));


        for (int i = 1; i <= 2*num - 1 ; i++) {
            System.out.printf("%s*%s*%s*%s%n", repeatStr(".", ((4*num+1)-3-2*i)/2),
                    repeatStr("-", i),
                    repeatStr("-", i),
                    repeatStr(".", ((4*num+1)-3-2*i)/2));
        }

        System.out.printf("%s%n", repeatStr("*", 4*num + 1));
        System.out.printf("%s*%n", repeatStr("*.", 2*num));
        System.out.printf("%s%n", repeatStr("*", 4*num + 1));
    }
    private static String repeatStr (String symbol, int count){
        String result = "";

        for (int i = 0; i < count; i++) {
            result += symbol;
        }
        return result;
    }
}
