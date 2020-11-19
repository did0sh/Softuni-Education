package exam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private Collection<Car> participants;

    public Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    public void addParticipant(Car car){
        this.participants.add(car);
    }

    public Collection<Car> getParticipants() {
        return Collections.unmodifiableCollection(this.participants);
    }

    protected Collection<Car> getWinners(){
        return this.participants.stream().sorted((car1,car2) ->{
            String raceType = this.getClass().getSimpleName();
            switch (raceType){
                case "CasualRace":
                    return car2.getOverallPerformance() - car1.getOverallPerformance();
                case "DragRace":
                    return car2.getEnginePerformance() - car1.getEnginePerformance();
                case "DriftRace":
                    return car2.getSuspensionPerformance() - car1.getSuspensionPerformance();
                    default: return 0;
            }
        }).limit(3)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    protected int getLength() {
        return this.length;
    }

    protected String getRoute() {
        return this.route;
    }

    protected int getPrizePool() {
        return this.prizePool;
    }
}
