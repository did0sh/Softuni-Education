import java.util.Scanner;

public class House {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        int starsCount = 0;

        if (number % 2 == 0){
            starsCount = 2;
        } else {
            starsCount = 1;
        }

        for (int i = 0; i < (number+1)/2 ; i++) {
                System.out.printf("%s%s%s%n", repeatStr("-",(number - starsCount)/2 - i),
                repeatStr("*", starsCount + 2*i ),
                repeatStr("-", (number-starsCount)/2 - i));
        }

        for (int j = 0; j < number/2  ; j++) {
            System.out.printf("|%s|%n",repeatStr("*", number - 2));
        }
    }
    public static String repeatStr (String symbol , int count){
        String result = "";

        for (int i = 0; i < count ; i++) {
            result += symbol;
        }
        return result;
    }
}
