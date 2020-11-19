import java.util.Scanner;

public class MaxCombination {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int maxCombinations = Integer.parseInt(scan.nextLine());

        int combinations = 0;

        for (int i = start; i <= end ; i++) {
            for (int j = start; j <= end ; j++) {

                combinations++;

                if (combinations != maxCombinations){
                    System.out.printf("<%d-%d>", i,j);
                } else {
                    System.out.printf("<%d-%d>",i,j);
                    return;
                }
            }
        }
    }
}
