import java.util.Scanner;

public class StopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());
        int stopNum = Integer.parseInt(scan.nextLine());

        for (int i = secondNum; i >= firstNum ; i--) {
               if (i%2 == 0 && i%3 == 0){

                   if (i == stopNum){
                       break;
                   }
                   System.out.printf("%d ", i);
               }


        }
    }
}
