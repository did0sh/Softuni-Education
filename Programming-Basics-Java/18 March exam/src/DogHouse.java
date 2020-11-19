import java.util.Scanner;

public class DogHouse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double side = Double.parseDouble(scan.nextLine());
        double height = Double.parseDouble(scan.nextLine());

        double straniciArea = 2 * side * (side/2);
        double zadnaStena = (side/2)*(side/2) + ((side/2)*(height-(side/2))/2);
        double prednaStena = zadnaStena - (side/5)*(side/5);

        double sumSteni = straniciArea + zadnaStena + prednaStena;

        double greenPaint = sumSteni / 3;
        System.out.printf("%.2f%n", greenPaint);

        double roof = 2*side*(side/2);
        double redPaint = roof / 5;

        System.out.printf("%.2f", redPaint);
    }
}
