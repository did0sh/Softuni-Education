import java.util.Scanner;

public class TrainersSalary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lectures = Integer.parseInt(scan.nextLine());
        double budget = Double.parseDouble(scan.nextLine());
        double sumRoli = 0;
        double sumJelev = 0;
        double sumRoyal = 0;
        double sumTrofon = 0;
        double sumSino = 0;
        double sumGuest = 0;


        for (int i = 0; i < lectures ; i++) {
            String nameOfLecturer = scan.nextLine().toLowerCase();

            if (nameOfLecturer.equals("jelev")){
                sumJelev++;
            } else if (nameOfLecturer.equals("royal")){
                sumRoyal++;
            } else if (nameOfLecturer.equals("roli")){
                sumRoli++;
            } else if (nameOfLecturer.equals("trofon")){
                sumTrofon++;
            } else if (nameOfLecturer.equals("sino")){
                sumSino++;
            } else {
                sumGuest++;
            }
        }

        double moneyPaid = budget/lectures;

        System.out.printf("Jelev salary: %.2f lv%n", moneyPaid*sumJelev);
        System.out.printf("RoYaL salary: %.2f lv%n", moneyPaid*sumRoyal);
        System.out.printf("Roli salary: %.2f lv%n", moneyPaid*sumRoli);
        System.out.printf("Trofon salary: %.2f lv%n", moneyPaid*sumTrofon);
        System.out.printf("Sino salary: %.2f lv%n", moneyPaid*sumSino);
        System.out.printf("Others salary: %.2f lv%n", moneyPaid*sumGuest);
    }
}
