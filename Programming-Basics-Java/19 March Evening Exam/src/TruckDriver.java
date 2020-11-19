import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String season = scan.nextLine();
        double kilometeresAMonth = Double.parseDouble(scan.nextLine());
        double salary = 0;

        if (kilometeresAMonth <= 5000){
            if (season.equals("Spring") || season.equals("Autumn")){
                salary = ((kilometeresAMonth * 0.75)*4) - 0.1*((kilometeresAMonth * 0.75)*4);
                System.out.printf("%.2f",salary);
            } else if (season.equals("Summer")){
                salary = ((kilometeresAMonth * 0.90)*4) - 0.1*((kilometeresAMonth * 0.90)*4);
                System.out.printf("%.2f",salary);
            } else if (season.equals("Winter")){
                salary = ((kilometeresAMonth * 1.05)*4) - 0.1*((kilometeresAMonth * 1.05)*4);
                System.out.printf("%.2f",salary);
            }
        }

        if (kilometeresAMonth > 5000 && kilometeresAMonth <=10000){
            if (season.equals("Spring") || season.equals("Autumn")){
                salary = ((kilometeresAMonth * 0.95)*4) - 0.1*((kilometeresAMonth * 0.95)*4);
                System.out.printf("%.2f",salary);
            } else if (season.equals("Summer")){
                salary = ((kilometeresAMonth * 1.10)*4) - 0.1*((kilometeresAMonth * 1.10)*4);
                System.out.printf("%.2f",salary);
            } else if (season.equals("Winter")){
                salary = ((kilometeresAMonth * 1.25)*4) - 0.1*((kilometeresAMonth * 1.25)*4);
                System.out.printf("%.2f",salary);
            }
        }

        if (kilometeresAMonth > 10000 && kilometeresAMonth <= 20000){
            salary = ((kilometeresAMonth * 1.45)*4) - 0.1*((kilometeresAMonth * 1.45)*4);
            System.out.printf("%.2f",salary);
        }

    }
}
