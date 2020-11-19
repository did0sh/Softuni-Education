import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        System.out.printf("%s%s%s%n",
                repeatStr(".", num),
                repeatStr("*", num*3),
                repeatStr(".", num));

        for (int i = 1; i <=num ; i++) {
            if (i == num){
                System.out.printf("%s%n",repeatStr("*", 5*num));
            } else{
                System.out.printf("%s*%s*%s%n",
                        repeatStr(".", num - i),
                        repeatStr(".", num*5 - 2*(num - i) - 2),
                        repeatStr(".", num - i));
            }

        }

        for (int i = 1; i <= (num*2) ; i++) {
            System.out.printf("%s*%s*%s%n",
                        repeatStr(".", i),
                        repeatStr(".", num*5 - 2*i - 2),
                        repeatStr(".", i));

            if (i == num*2) {
                System.out.printf("%s%s%s",
                        repeatStr(".", num * 2 + 1),
                        repeatStr("*", num - 2),
                        repeatStr(".", num * 2 + 1));

            }

        }

}

    private static String repeatStr (String symbol , int count){
        String result = "";

        for (int i = 0; i < count; i++) {
            result += symbol;
        }
        return result;
    }
}
