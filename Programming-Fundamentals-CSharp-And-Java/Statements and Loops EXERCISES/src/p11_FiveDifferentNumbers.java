import java.util.Scanner;

/**
 * Created by user on 24.9.2017 г..
 */
public class p11_FiveDifferentNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int combinationsCount = 0;

        for (int i = start; i <= end ; i++) {
            for (int j = start ; j <= end; j++) {
                for (int k = start ; k <= end ; k++) {
                    for (int l = start ; l <= end ; l++) {
                        for (int m = start; m <= end ; m++) {

                            boolean isValid = (start <= i ) && (i < j) && (j < k) && (k < l) && (l < m) && (m <= end);
                            if (isValid){
                                System.out.printf("%d %d %d %d %d%n",i,j,k,l,m);
                                combinationsCount++;
                            }
                        }
                    }
                }
            }
        }

        if (combinationsCount == 0){
            System.out.println("No");
        }
    }
}
