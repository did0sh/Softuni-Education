
import java.util.Scanner;

public class p05_SymmetricNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        boolean isSynmmetric = false;

        for (int i = 1; i <= n; i++) {
            String str = i + "";

            if(str.length() < 2){
                System.out.print(i + " ");

            } else {

                for (int j = 0; j < (int)Math.floor(str.length()/2); j++) {
                    if(str.charAt(j) != str.charAt(str.length() - 1 - j)){
                        isSynmmetric = false;
                        break;
                    } else {
                        isSynmmetric = true;
                    }
                }

                if(isSynmmetric){
                    System.out.print(i + " ");
                }
            }
        }
    }
}
