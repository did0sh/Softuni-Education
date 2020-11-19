import java.util.Scanner;

public class Diamond {
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
            if (i == 0){
                System.out.printf("%s%s%s%n",
                        repeatStr("-", (num - starsCount)/2)
                        ,repeatStr("*", starsCount)
                        ,repeatStr("-", (num - starsCount)/2));
            } else {
                System.out.printf("%s*%s*%s%n",
                        repeatStr("-", (num - starsCount)/2 - i)
                        ,repeatStr("-", starsCount + i*2 - 2)
                        ,repeatStr("-", (num - starsCount)/2 - i));
            }

        }

        for (int i = 1;  i <= (num/2) - 1 ; i++) {
                System.out.printf("%s*%s*%s%n"
                        ,repeatStr("-", i)
                        ,repeatStr("-", num - 2 - 2*i)
                        ,repeatStr("-", i));


        }

        if (num % 2 == 1){
            System.out.printf("%s*%s"
            ,repeatStr("-", (num - starsCount)/2)
            ,repeatStr("-", (num - starsCount)/2));
        }





    }
    private static String repeatStr (String symbol, int count){
        String result = "";

        for (int j = 0; j < count ; j++) {
            result += symbol;
        }
        return result;
    }
}
