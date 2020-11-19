import java.util.Scanner;

public class TradeComissions {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        String town = scan.nextLine().toLowerCase();
        double sales = Double.parseDouble(scan.nextLine());
        double commision = -1;

        if (town.equals("sofia")){
            if (sales >=0 && sales <=500){
                commision = sales * 0.05;
            } else if (sales > 500 && sales <=1000){
                commision = sales * 0.07;
            } else if (sales > 1000 && sales <= 10000){
                commision = sales * 0.08;
            } else if (sales > 10000){
                commision = sales * 0.12;
            }

    }

            if (town.equals("varna")) {
                if (sales >= 0 && sales <= 500) {
                    commision = sales * 0.045;
                } else if (sales > 500 && sales <= 1000) {
                    commision = sales * 0.075;
                } else if (sales > 1000 && sales <= 10000) {
                    commision = sales * 0.1;
                } else if (sales > 10000) {
                    commision = sales * 0.13;
                }
            }

            if (town.equals("plovdiv")){
                if (sales >=0 && sales <=500){
                    commision = sales * 0.055;
                } else if (sales > 500 && sales <=1000){
                    commision = sales * 0.08;
                } else if (sales > 1000 && sales <= 10000){
                    commision = sales * 0.12;
                } else if (sales > 10000){
                    commision = sales * 0.145;
                }

            }

            if (commision >= 0){
                System.out.printf("%.2f", commision);
            } else {
                System.out.println("error");
            }

        }

}
