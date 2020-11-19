import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String month = scan.nextLine();
        int nights = Integer.parseInt(scan.nextLine());
        double sumStudio = 0.0;
        double sumApartament = 0.0;
        double sumAfterNamalenie = 0.0;
        double sumAfterNamalenieAp = 0.0;


        if (month.equals("May")  || month.equals("October")){
                sumStudio =  50.00;
                sumApartament = 65.00;
        } else if (month.equals("June") || month.equals("September")){
            sumStudio = 75.20;
            sumApartament = 68.70;
        } else if (month.equals("July") || month.equals("August")){
            sumStudio = 76.00;
            sumApartament = 77.00;
        }

        if (nights > 7 && nights <= 14 && (month.equals("May")  || month.equals("October"))){
            sumAfterNamalenie =  sumStudio - 0.05*sumStudio;
        } else if (nights > 14 && (month.equals("May")  || month.equals("October"))){
            sumAfterNamalenie = sumStudio -  0.3*sumStudio;
        } else if (nights > 14 && (month.equals("June")  || month.equals("September"))){
            sumAfterNamalenie = sumStudio - 0.2*sumStudio;
        } else {
            sumAfterNamalenie = sumStudio;
        }

        if (nights > 14) {
            sumAfterNamalenieAp = sumApartament - 0.1 * sumApartament;
        } else {
            sumAfterNamalenieAp = sumApartament;
        }

        double allsumApartament = sumAfterNamalenieAp * nights;
        double allsumStudio = sumAfterNamalenie * nights;

        System.out.printf("Apartment: %.2f lv.%n", allsumApartament);
        System.out.printf("Studio: %.2f lv.", allsumStudio);
    }
}
