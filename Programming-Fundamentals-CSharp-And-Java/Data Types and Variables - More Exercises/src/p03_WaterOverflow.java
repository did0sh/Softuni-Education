import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;

/**
 * Created by user on 2.10.2017 г..
 */
public class p03_WaterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pipesCount = Integer.parseInt(scan.nextLine());
        int sum = 0;

        while (pipesCount > 0){
             int number = Integer.parseInt(scan.nextLine());

           if (sum + number <= 255){
               sum += number;
           } else {
               System.out.println("Insufficient capacity!");
           }

           pipesCount--;
        }

        System.out.println(sum);
    }
}
