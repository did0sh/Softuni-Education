import java.util.Scanner;

public class Problem05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int width = 4*n+1;

        System.out.printf("%s%n",repeatStr("#",width));

        for (int i = 1; i <=n ; i++) {
            if (i == n/2 + 1){
                System.out.printf("%s%s%s(@)%s%s%s%n",
                        repeatStr(".", i),
                        repeatStr("#", (width - 2*i - (2*i-1))/2),
                        repeatStr(" ", (2*i-1-3)/2),
                        repeatStr(" ", (2*i-1-3)/2),
                        repeatStr("#", (width - 2*i - (2*i-1))/2),
                        repeatStr(".", i));
            } else  {
                System.out.printf("%s%s%s%s%s%n",
                        repeatStr(".", i),
                        repeatStr("#", (width - 2*i - (2*i-1))/2),
                        repeatStr(" ", 2*i-1),
                        repeatStr("#", (width - 2*i - (2*i-1))/2),
                        repeatStr(".", i));
            }

        }

        for (int i = 1; i <=n; i++) {
            System.out.printf("%s%s%s%n",
                    repeatStr(".", n+i),
                    repeatStr("#", width - 2*(n+i)),
                    repeatStr(".", n+i));
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
