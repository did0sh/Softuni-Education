import java.util.Scanner;

public class p09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        int starsCount = 0;
        if (num % 2 == 0){
            starsCount = 2;
        } else {
            starsCount = 1;
        }
        for (int i = 0; i < (num+1)/2 ; i++) {
            System.out.printf("%s%s%s%n",
                    repeatStr("-", (num - starsCount)/2 - i),
                    repeatStr("*", starsCount + 2*i),
                    repeatStr("-", (num-starsCount)/2 - i));
        }

        for (int i = 0; i < num/2 ; i++) {
            System.out.printf("|%s|%n", repeatStr("*", num - 2));
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
