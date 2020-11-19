import java.util.Scanner;

public class SoftuniLogo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n*2 ; i++) {
            System.out.printf("%s%s%s%n",
                    repeatStr(".", ((12*n-5)-(i*6+1))/2),
                    repeatStr("#", i*6 + 1),
                    repeatStr(".", ((12*n-5)-(i*6+1))/2));
        }

         for (int i = 1; i <= n -2  ; i++) {
             System.out.printf("|%s%s%s%n",
                     repeatStr(".", i*3-1),
                     repeatStr("#", (12*n-5)-2*(i*3)),
                     repeatStr(".", i*3));
         }

        for (int i = 0; i <= n-2 ; i++) {
            System.out.printf("|%s%s%s%n",
                    repeatStr(".", ((12*n - 6)-(6*n+1))/2),
                    repeatStr("#", 6*n + 1),
                    repeatStr(".", ((12*n - 5)-(6*n+1))/2));
        }

        System.out.printf("@%s%s%s%n",
                repeatStr(".", ((12*n - 6)-(6*n+1))/2),
                repeatStr("#", 6*n + 1),
                repeatStr(".", ((12*n - 5)-(6*n+1))/2));


     }

    private static String repeatStr (String symbol, int count){
        String result = "";

        for (int i = 0; i < count; i++) {
            result += symbol;
        }
        return result;
    }
}
