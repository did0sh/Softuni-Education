import java.util.Scanner;

public class Axe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        System.out.printf("%s**%s%n", repeatStr("-", 3*num),
                repeatStr("-", 5*num - 3*num - 2));

        for (int i = 1; i <= num - 1 ; i++) {
            System.out.printf("%s*%s*%s%n",
                    repeatStr("-", 3*num),
                    repeatStr("-", i),
                    repeatStr("-", 5*num - 3*num - 2 - i));
        }

        for (int i = 1; i <= num/2 ; i++) {
            System.out.printf("%s*%s*%s%n",repeatStr("*", 3*num),
                    repeatStr("-", num-1),
                    repeatStr("-", num-1));
        }

        for (int i = 0; i < (num-2)/2 ; i++) {
            System.out.printf("%s*%s*%s%n", repeatStr("-", 3*num - i),
                    repeatStr("-", 5*num -2 - ((3*num -i) + (num - 1 - i))),
                    repeatStr("-", num - 1 - i));
        }

        if (num %2==0){
            System.out.printf("%s%s%s",
                    repeatStr("-", 5*num - ((2*num -1)+(num+1)/2)),
                    repeatStr("*", 2*num -1),
                    repeatStr("-", (num+1)/2));
        } else {
            System.out.printf("%s%s%s",
                    repeatStr("-", 5*num - ((2*num -2)+(num+1)/2)),
                    repeatStr("*", 2*num -2),
                    repeatStr("-", (num+1)/2));
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
