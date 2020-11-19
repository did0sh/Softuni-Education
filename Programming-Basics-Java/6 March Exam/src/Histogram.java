import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countNumbers = Integer.parseInt(scan.nextLine());
        double sumBelow200 = 0;
        double sumBetween200And399 = 0;
        double sumBetween400And599 = 0;
        double sumBetween600And799 = 0;
        double sumAbove800 = 0;

        for (int i = 0; i < countNumbers ; i++) {
            int number = Integer.parseInt(scan.nextLine());

            if (number < 200){
                sumBelow200++;
            } else if (number >= 200 && number <= 399){
                sumBetween200And399++;
            } else if (number >= 400 && number <= 599){
                sumBetween400And599++;
            } else if (number >= 600 && number <= 799){
                sumBetween600And799++;
            } else if (number >= 800){
                sumAbove800++;
            }
        }

        double p1 = (sumBelow200*100)/countNumbers;
        double p2 = (sumBetween200And399*100)/countNumbers;
        double p3 = (sumBetween400And599*100)/countNumbers;
        double p4 = (sumBetween600And799*100)/countNumbers;
        double p5 = (sumAbove800*100)/countNumbers;

        System.out.printf("%.02f%%\n", p1);
        System.out.printf("%.02f%%\n", p2);
        System.out.printf("%.02f%%\n", p3);
        System.out.printf("%.02f%%\n", p4);
        System.out.printf("%.02f%%", p5);
    }
}
