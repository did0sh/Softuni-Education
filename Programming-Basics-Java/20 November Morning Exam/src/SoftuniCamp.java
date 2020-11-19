import java.util.Scanner;

public class SoftuniCamp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int groups = Integer.parseInt(scan.nextLine());

        int sumPeople = 0;

        int sumCar = 0;
        int sumMikrobus = 0;
        int sumSmallBus = 0;
        int sumBigBus = 0;
        int sumTrain = 0;

        for (int i = 0; i < groups ; i++) {
            int numberOfPeople = Integer.parseInt(scan.nextLine());

            sumPeople += numberOfPeople;

            if (numberOfPeople <=5){
                sumCar += numberOfPeople;
            } else if (numberOfPeople > 5 && numberOfPeople <= 12){
                sumMikrobus += numberOfPeople;
            } else if (numberOfPeople > 12 && numberOfPeople <=25){
                sumSmallBus += numberOfPeople;
            } else if (numberOfPeople > 25 && numberOfPeople <= 40){
                sumBigBus += numberOfPeople;
            } else if (numberOfPeople > 40){
                sumTrain += numberOfPeople;
            }
        }


        double procentCar = (sumCar*100)/(double)sumPeople;
        double procentMikrobus = (sumMikrobus*100)/(double)sumPeople;
        double procentSmallBus = (sumSmallBus*100)/(double)sumPeople;
        double procentBigBus = (sumBigBus*100)/(double)sumPeople;
        double procentTrain = (sumTrain*100)/(double)sumPeople;

        System.out.printf("%.2f%%%n",procentCar);
        System.out.printf("%.2f%%%n",procentMikrobus);
        System.out.printf("%.2f%%%n",procentSmallBus);
        System.out.printf("%.2f%%%n",procentBigBus);
        System.out.printf("%.2f%%%n",procentTrain);

    }
}
