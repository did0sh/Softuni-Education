import java.util.Scanner;

public class LettersCombination {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char start = scan.nextLine().charAt(0);
        char end = scan.nextLine().charAt(0);
        char ignore = scan.nextLine().charAt(0);

        int count = 0;

        for (char i = start; i <= end ; i++) {
            for (char j = start; j <= end ; j++) {
                for (char k = start; k <= end ; k++) {
                    if (k != ignore && j != ignore && i != ignore){
                        count++;
                        System.out.printf("%s%s%s ", i,j,k);
                    }

                }
            }
        }
        System.out.printf("%d", count);
    }
}
