import java.util.Scanner;

/**
 * Created by user on 21.9.2017 г..
 */
public class p03_BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

       minutes += 30;

       if (minutes > 59) {
           hours += 1;
           minutes -= 60;
       }

       if (hours > 23){
           hours = 0;
       }

        System.out.printf("%d:%02d", hours, minutes);
    }
}
