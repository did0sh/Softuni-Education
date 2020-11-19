import java.util.Scanner;

public class p10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        int starsCount = 0;
        int height = 0;
        if (num % 2 == 0){
            starsCount = 2;
            height = num - 1;
        } else {
            height = num;
            starsCount = 1;
        }


        for (int i = 0; i < (num+1)/2 ; i++) {
            if (num % 2 == 0){
                System.out.printf("%s*%s*%s%n",
                        repeatStr("-", (num - starsCount)/2 - i),
                        repeatStr("-", i*2),
                        repeatStr("-", (num-starsCount)/2 - i));
            } else {
                if (i == 0){
                    System.out.printf("%s*%s%n",
                            repeatStr("-", (num - starsCount)/2 ),
                            repeatStr("-", (num - starsCount)/2 ));
                } else {
                    System.out.printf("%s*%s*%s%n",
                            repeatStr("-", (num - starsCount)/2 - i),
                            repeatStr("-", i*2 - 1),
                            repeatStr("-", (num-starsCount)/2 - i));
                }

            }
        }

        for (int i = 1; i <= (num-1)/2 ; i++) {
            if (num % 2 == 0){
                System.out.printf("%s*%s*%s%n",
                        repeatStr("-", i),
                        repeatStr("-", num - 2 - 2*i),
                        repeatStr("-", i));
            } else {
                if (i == (num-1)/2){
                    System.out.printf("%s*%s%n",
                            repeatStr("-", i),
                            repeatStr("-", i));
                } else {
                    System.out.printf("%s*%s*%s%n",
                            repeatStr("-", i),
                            repeatStr("-", num - 2 - 2*i),
                            repeatStr("-", i));
                }

            }

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
