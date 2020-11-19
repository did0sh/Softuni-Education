import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String year = scan.nextLine();
        int p = Integer.parseInt(scan.nextLine());
        int h = Integer.parseInt(scan.nextLine());

        int weekendsInSofia = 48 - h;
        double gamesInSofia = weekendsInSofia * 3.0/4;

        double gamesInHolidays = p * 2.0/3;

        double sumOfgames = gamesInSofia + h + gamesInHolidays;

        double gamesInA366Year = 0.0;

        if (year.equals("leap")){
           gamesInA366Year = sumOfgames * 0.15;
           double result = gamesInA366Year + sumOfgames;
            System.out.println(Math.floor(result));
        } else if (year.equals("normal")){
            System.out.println(Math.floor(sumOfgames));
        }
    }
}
