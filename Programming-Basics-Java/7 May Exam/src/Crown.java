import java.util.Scanner;

public class Crown {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        System.out.printf("@%s@%s@%n",
                repeatStr(" ", num - 2),
                repeatStr(" ", num - 2));


        for (int i = 0; i <= num/2; i++) {
            if (i == 0){
                System.out.printf("*%s*%s*%s*%s*%n",
                        repeatStr(" ", i),
                        repeatStr(" ", ((num*2 - 1) - 5)/2),
                        repeatStr(" ", ((num*2 - 1) - 5)/2),
                        repeatStr(" ", i));
            } else {
                if (i == 1) {
                    System.out.printf("*%s*%s*%s*%s*%s*%n",
                            repeatStr(".", i),
                            repeatStr(" ", ((num*2-1)-9)/2),
                            repeatStr(".", i),
                            repeatStr(" ", ((num*2-1)-9)/2),
                            repeatStr(".", i));
                } else {
                    if (i == num/2 -1) {
                        System.out.printf("*%s*%s*%s*%n",
                                repeatStr(".", i ),
                                repeatStr(".", (num*2-1)-4-2*i),
                                repeatStr(".", i ));
                    } else {
                        if (i == num/2){
                            System.out.printf("*%s%s.%s%s*%n",
                                    repeatStr(".", i),
                                    repeatStr("*", ((num*2-1)-3-2*i)/2),
                                    repeatStr("*", ((num*2-1)-3-2*i)/2),
                                    repeatStr(".", i));
                        } else {
                            System.out.printf("*%s*%s*%s*%s*%s*%n",
                                    repeatStr(".", i),
                                    repeatStr(" ", ((num*2-1)-6-4*i+1)/2),
                                    repeatStr(".", i*2 - 1),
                                    repeatStr(" ", ((num*2-1)-6-4*i+1)/2),
                                    repeatStr(".", i));
                        }
                    }
                }
            }
        }


        System.out.printf("%s%n",repeatStr("*", num*2-1));
        System.out.printf("%s%n",repeatStr("*", num*2-1));
    }
    private static String repeatStr (String symbol, int count){
        String result = "";

        for (int i = 0; i < count; i++) {
            result += symbol;
        }
        return result;
    }
}
