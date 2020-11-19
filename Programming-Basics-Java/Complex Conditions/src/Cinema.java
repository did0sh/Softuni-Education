import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String movieType = scan.nextLine();
        int rows = Integer.parseInt(scan.nextLine());
        int columns = Integer.parseInt(scan.nextLine());

        double price = -1;

        switch (movieType){
            case "Premiere":
                price = 12.00;
                break;
            case "Normal":
                price = 7.50;
                break;
            case "Discount":
                price = 5.00;
                break;
        }
        double result = price * rows * columns;
        System.out.printf("%.2f leva", result);
    }
}
