import java.util.Scanner;

/**
 * Created by user on 4.10.2017 г..
 */
public class p02_MaxMethod {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());

        if (c > getMax(a,b)) {
            System.out.println(c);
        } else {
            System.out.println(getMax(a,b));
        }
    }

    static int getMax (int a, int b){
        int biggerNum = 0;
        if (a > b){
            biggerNum = a;
        } else if (b > a) {
            biggerNum = b;
        }

        return biggerNum;

    }
}
