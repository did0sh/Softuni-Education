import java.util.Scanner;

public class GameOFIntervals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int moves = Integer.parseInt(scan.nextLine());

        int numbers0to9 = 0;
        int numbers10to19 = 0;
        int numbers20to29 = 0;
        int numbers30to39 = 0;
        int numbers40to50 = 0;
        int invalidNumbers = 0;

        double endResult = 0.0;

        for (int i = 0; i < moves ; i++) {
            int numbers = Integer.parseInt(scan.nextLine());


            if (numbers >= 0 && numbers <=9){
                numbers0to9++;
                endResult = endResult + 0.2*numbers;
            } else if (numbers >= 10 && numbers <=19){
                numbers10to19++;
                endResult = endResult + 0.3*numbers;
            } else if (numbers >= 20 && numbers <=29){
                numbers20to29++;
                endResult = endResult + 0.4*numbers;
            } else if (numbers >= 30 && numbers <=39){
                numbers30to39++;
                endResult = endResult + 50;
            } else if (numbers >= 40 && numbers <=50){
                numbers40to50++;
                endResult+= 100;
            } else if (numbers < 0 || numbers > 50){
                invalidNumbers++;
                endResult = endResult/2;
            }
        }

        System.out.printf("%.2f%n", endResult);

        double percent1 = (numbers0to9*100)/(double) moves;
        double percent2 = (numbers10to19*100)/(double) moves;
        double percent3 = (numbers20to29*100)/(double) moves;
        double percent4 = (numbers30to39*100)/(double) moves;
        double percent5 = (numbers40to50*100)/(double) moves;
        double percent6 = (invalidNumbers*100)/(double) moves;

        System.out.printf("From 0 to 9: %.2f%%%n", percent1);
        System.out.printf("From 10 to 19: %.2f%%%n", percent2);
        System.out.printf("From 20 to 29: %.2f%%%n", percent3);
        System.out.printf("From 30 to 39: %.2f%%%n", percent4);
        System.out.printf("From 40 to 50: %.2f%%%n", percent5);
        System.out.printf("Invalid numbers: %.2f%%%n", percent6);
    }
}
