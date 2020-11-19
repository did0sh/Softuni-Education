import java.util.Scanner;

public class p06 {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= num ; i++) {
            System.out.printf("%s%s%n",
                    repeatStr(" ", num - i)
            ,repeatStr("* ", i).trim());
        }

        for (int i = 1; i < num; i++) {
            System.out.printf("%s%s%n",
                     repeatStr(" ", i)
                    ,repeatStr("* ", num - i).trim());
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
