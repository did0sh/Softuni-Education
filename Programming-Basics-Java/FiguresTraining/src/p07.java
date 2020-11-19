import java.util.Scanner;

public class p07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        System.out.printf("%s|%s%n",
                repeatStr(" ", num + 1),
                repeatStr(" ", num + 1));

        for (int i = 1; i <= num; i++) {
            System.out.printf("%s%s | %s%s%n",
                    repeatStr(" ", num - i),
                    repeatStr("*", i),
                    repeatStr("*", i),
                    repeatStr(" ", num - i));
        }
        
    }
    private static String repeatStr(String symbol, int count){
        String result = "";

        for (int i = 0; i < count; i++) {
            result += symbol;
        }
        return result;
    }
}
