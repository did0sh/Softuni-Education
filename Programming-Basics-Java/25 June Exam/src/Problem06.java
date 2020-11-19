import java.util.Scanner;

public class Problem06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int controlNum = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int proizvedenie = 0;
        int a = 0;
        int b = 0;
        int c = 0;

        int combinationsCount = 0;

        for (a = 1; a <= 30 ; a++) {
            for (b = 1; b <=30 ; b++) {
                for (c = 1; c <=30 ; c++) {
                    sum = a+b+c;
                    proizvedenie = a*b*c;



                    if (sum == controlNum && a<b && b<c){
                        System.out.printf("%d + %d + %d = %d%n", a,b,c,controlNum);
                        combinationsCount++;
                    }

                    if (proizvedenie == controlNum && a>b && b>c){
                        System.out.printf("%d * %d * %d = %d%n", a,b,c,controlNum);
                        combinationsCount++;
                    }

                }
            }
        }

        if (combinationsCount == 0){
            System.out.printf("No!");
        }

    }
}
