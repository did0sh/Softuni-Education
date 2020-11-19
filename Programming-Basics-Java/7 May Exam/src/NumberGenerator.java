import java.util.Scanner;

public class NumberGenerator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int M = Integer.parseInt(scan.nextLine());
        int N = Integer.parseInt(scan.nextLine());
        int L = Integer.parseInt(scan.nextLine());
        int specialNumber = Integer.parseInt(scan.nextLine());
        int controlNumber = Integer.parseInt(scan.nextLine());

        for (int i = M; i >=1 ; i--) {
            for (int j = N; j >=1 ; j--) {
                for (int k = L; k >=1 ; k--) {
                    int num = i*100 + j*10 + k;

                    if (num%3 == 0){
                        specialNumber +=5;
                    } else if (num % 10 == 5){
                        specialNumber -= 2;
                    } else if (num % 2 == 0){
                        specialNumber *= 2;
                    }

                    if (specialNumber >= controlNumber){
                        System.out.printf("Yes! Control number was reached! Current special number is %d.", specialNumber);
                        return;
                    }
                }
            }
        }

           if (specialNumber < controlNumber){
               System.out.printf("No! %d is the last reached special number.", specialNumber);
           }


    }
}

