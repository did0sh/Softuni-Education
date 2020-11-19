import java.io.PrintStream;
import java.util.Scanner;

public class MagicCombination {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int input = Integer.parseInt(scan.nextLine());

        for (int i = 1; i < 10 ; i++) {
            for (int j = 1; j < 10 ; j++) {
                for (int k = 1; k < 10 ; k++) {
                    for (int l = 1; l < 10 ; l++) {
                        for (int m = 1; m < 10 ; m++) {
                            for (int n = 1; n < 10 ; n++) {

                                if (i*j*k*l*m*n == input) {
                                    System.out.printf("%d%d%d%d%d%d ", i, j, k, l, m, n);
                                }


                            }
                        }
                    }
                }
            }
        }
    }
}
