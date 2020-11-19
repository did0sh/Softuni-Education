import java.util.Scanner;

/**
 * Created by user on 3.10.2017 г..
 */
public class p08_GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String type = scan.nextLine();

        if (type.equals("int")){

            int first = Integer.parseInt(scan.nextLine());
            int second = Integer.parseInt(scan.nextLine());
            int max = getMax(first,second);
            System.out.println(max);

        } else if (type.equals("char")){

            char first = scan.nextLine().charAt(0);
            char second = scan.next().charAt(0);
            char max = getMax(first, second);
            System.out.println(max);

        } else if (type.equals("string")){

            String first = scan.nextLine();
            String second = scan.nextLine();
            String max = getMax(first,second);
            System.out.println(max);
        }
    }

    static int getMax (int first, int second){

        int biggerNum = 0;
        if (first > second){
            biggerNum = first;
        } else if (second > first){
            biggerNum = second;
        }

        return biggerNum;
    }

    static char getMax (char first, char second){

        char biggerChar = 0;
        if (first > second){
            biggerChar = first;
        } else if (second > first){
            biggerChar = second;
        }

        return biggerChar;
    }

    static String getMax (String first, String second){

        String biggerString = "";
        if (first.compareTo(second) > 0){
            biggerString = first;
        } else if (first.compareTo(second) < 0){
            biggerString = second;
        }

        return biggerString;
    }
}
