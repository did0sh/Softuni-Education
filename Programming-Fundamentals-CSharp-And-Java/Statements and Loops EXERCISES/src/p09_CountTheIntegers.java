import java.util.Scanner;

/**
 * Created by user on 23.9.2017 г..
 */
public class p09_CountTheIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numCount = 0;

      try {
          while (true){
              int input = Integer.parseInt(scan.nextLine());
              numCount++;
          }

      } catch (Exception ex){
          System.out.println(numCount);
      }

    }
}
