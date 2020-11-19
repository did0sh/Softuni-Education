package exam.races;

import exam.Race;
import exam.Car;

import java.util.ArrayList;
import java.util.Collection;

public class CasualRace extends Race {
    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %d", super.getRoute(), super.getLength())).append(System.lineSeparator());

        Collection<Car> sorted = super.getWinners();
        int count = 0;
        int moneyWonCurrentCar = 0;
        for (Car cars : sorted) {
            count++;
            switch (count){
                case 1:
                    moneyWonCurrentCar = (50*super.getPrizePool()) / 100;
                    break;
                case 2:
                    moneyWonCurrentCar = (30*super.getPrizePool()) / 100;
                    break;
                case 3:
                    moneyWonCurrentCar = (20*super.getPrizePool()) / 100;
                    break;

            }
            sb.append(String.format("%d. %s %s %dPP - $%d",count, cars.getBrand(), cars.getModel(),
                    cars.getOverallPerformance(), moneyWonCurrentCar)).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
