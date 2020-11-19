import java.util.Scanner;

public class DrawFort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
//top part
        if (num >= 3 && num < 5){

        System.out.printf("/%s\\/%s\\%n",
                repeatStr("^", num/2),
                repeatStr("^", num/2));
        } else {
            System.out.printf("/%s\\%s/%s\\%n",
                    repeatStr("^", num/2),
                    repeatStr("_", num*2 - 4 - 2*(num/2)),
                    repeatStr("^", num/2));
        }
//middle
        for (int i = 0; i < num -2 ; i++) {
            if (num >= 5 && i == (num - 2) - 1 ){
                System.out.printf("|%s%s%s|%n",
                        repeatStr(" ", num/2 + 1),
                        repeatStr("_", num*2 - 2 - 2*((num/2+1))),
                        repeatStr(" ", num/2 + 1));
            } else {
                System.out.printf("|%s|%n",repeatStr(" ", num*2 - 2));
            }
        }
//bottom
        if (num >= 3 && num < 5){
            System.out.printf("\\%s/\\%s/",repeatStr("_", num/2),
                    repeatStr("_", num/2));
        } else {
            System.out.printf("\\%s/%s\\%s/",repeatStr("_", num/2),
                    repeatStr(" ", num*2 - 4 - 2*(num/2)),
                    repeatStr("_", num/2));
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
