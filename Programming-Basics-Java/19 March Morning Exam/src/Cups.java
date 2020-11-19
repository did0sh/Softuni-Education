import java.util.Scanner;

public class Cups {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int glassesNeeded = Integer.parseInt(scan.nextLine());
        int numberOfWorkers = Integer.parseInt(scan.nextLine());
        int workDays = Integer.parseInt(scan.nextLine());

        int hoursWorking = numberOfWorkers * workDays * 8;
        double glassesProduced = Math.floor(hoursWorking / 5.0);
        double difference = Math.abs(glassesNeeded - glassesProduced);
        double lossesOrProfits = difference * 4.2;

        if (glassesProduced < glassesNeeded){
            System.out.printf("Losses: %.2f", lossesOrProfits);
        } else if (glassesProduced >= glassesNeeded){
            System.out.printf("%.2f extra money", lossesOrProfits);
        }
    }
}
