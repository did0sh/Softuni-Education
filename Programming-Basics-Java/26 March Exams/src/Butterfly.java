import java.util.Scanner;

public class Butterfly {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= num - 2 ; i++) {
            if (i % 2 == 1){
                System.out.printf("%s\\ /%s%n",
                        repeatStr("*",(2*num - 4)/2),
                        repeatStr("*",(2*num - 4)/2));
            } else {
                System.out.printf("%s\\ /%s%n",
                        repeatStr("-",(2*num - 4)/2),
                        repeatStr("-",(2*num - 4)/2));
            }
        }

        System.out.printf("%s@%s%n",repeatStr(" ", (2*num-2)/2),
                repeatStr(" ",(2*num-2)/2 ));

        for (int i = 1; i <= num - 2 ; i++) {
            if (i % 2 == 1){
                System.out.printf("%s/ \\%s%n",
                        repeatStr("*",(2*num - 4)/2),
                        repeatStr("*",(2*num - 4)/2));
            } else {
                System.out.printf("%s/ \\%s%n",
                        repeatStr("-",(2*num - 4)/2),
                        repeatStr("-",(2*num - 4)/2));
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
