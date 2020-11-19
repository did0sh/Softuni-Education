import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String categoryTicket = scan.nextLine();
        int numberOfPeople = Integer.parseInt(scan.nextLine());
        double budgetLeft = 0;
        double ticketPrice = 0;

        if (categoryTicket.equals("Normal")) {
            if (numberOfPeople >= 1 && numberOfPeople <= 4) {
                budgetLeft = budget - 0.75 * budget;
                ticketPrice = 249.99 * numberOfPeople;
            } else if (numberOfPeople >= 5 && numberOfPeople <= 9) {
                budgetLeft = budget - 0.6 * budget;
                ticketPrice = 249.99 * numberOfPeople;
            } else if (numberOfPeople >= 10 && numberOfPeople <= 24) {
                budgetLeft = budget - 0.5 * budget;
                ticketPrice = 249.99 * numberOfPeople;
            } else if (numberOfPeople >= 25 && numberOfPeople <= 49) {
                budgetLeft = budget - 0.4 * budget;
                ticketPrice = 249.99 * numberOfPeople;
            } else if (numberOfPeople >= 50) {
                budgetLeft = budget - 0.25 * budget;
                ticketPrice = 249.99 * numberOfPeople;
            }
        } else {

            if (categoryTicket.equals("VIP")){
                if (numberOfPeople >= 1 && numberOfPeople <= 4) {
                    budgetLeft = budget - 0.75 * budget;
                    ticketPrice = 499.99 * numberOfPeople;
                } else if (numberOfPeople >= 5 && numberOfPeople <= 9){
                    budgetLeft = budget - 0.6 * budget;
                    ticketPrice = 499.99 * numberOfPeople;
                } else if (numberOfPeople >=10 && numberOfPeople <=24){
                    budgetLeft = budget - 0.5 * budget;
                    ticketPrice = 499.99 * numberOfPeople;
                } else if (numberOfPeople >= 25 && numberOfPeople <=49){
                    budgetLeft = budget - 0.4 * budget;
                    ticketPrice = 499.99 * numberOfPeople;
                } else if (numberOfPeople >= 50){
                    budgetLeft = budget - 0.25 * budget;
                    ticketPrice = 499.99 * numberOfPeople;
                }
            }
        }

        double difference = Math.abs(budgetLeft - ticketPrice);

        if (budgetLeft >= ticketPrice ){
            System.out.printf("Yes! You have %.2f leva left.", difference);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", difference);
        }

    }
}
