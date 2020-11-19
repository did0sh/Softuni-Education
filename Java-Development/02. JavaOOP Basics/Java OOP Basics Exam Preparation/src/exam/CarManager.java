package exam;

import exam.cars.PerformanceCar;
import exam.cars.ShowCar;
import exam.races.CasualRace;
import exam.races.DragRace;
import exam.races.DriftRace;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarManager {
    private Map<Integer, Car> allCars;
    private Map<Integer, Race> allRaces;
    private Garage garage;

    public CarManager() {
        this.allCars = new LinkedHashMap<>();
        this.allRaces = new LinkedHashMap<>();
        this.garage = new Garage();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction,
                         int horsePower, int acceleration, int suspension, int durability){
        Car car = null;
        switch (type){
            case "Performance":
                car = new PerformanceCar(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);
                this.allCars.putIfAbsent(id, car);
                break;
            case "Show":
                car = new ShowCar(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);
                this.allCars.putIfAbsent(id, car);
                break;
        }
    }

    public String check(int id){
        Car currentCar = this.allCars.get(id);
        return currentCar.toString();
    }

    public void open(int id, String type, int length, String route, int prizePool){
        Race race = null;
        switch (type){
            case "Casual":
                race = new CasualRace(length, route, prizePool);
                this.allRaces.putIfAbsent(id, race);
                break;
            case "Drag":
                race = new DragRace(length, route, prizePool);
                this.allRaces.putIfAbsent(id, race);
                break;
            case "Drift":
                race = new DriftRace(length, route, prizePool);
                this.allRaces.putIfAbsent(id, race);
                break;
        }
    }

    public void participate(int carId, int raceId){
        Car car = this.allCars.get(carId);
        if (this.garage.getParkedCars().contains(car)){
            return;
        }
        Race currentRace = this.allRaces.get(raceId);
        currentRace.addParticipant(car);
        this.allRaces.put(raceId, currentRace);
    }

    public String start(int id){
        Race race = this.allRaces.get(id);
        if (race.getParticipants().size() == 0){
            return "Cannot start the race with zero participants.";
        }
        String result = race.toString();
        this.allRaces.remove(id);
        return result;
    }

    public void park(int id){
        if (!isInRace(id)){
            Car car = this.allCars.get(id);
            this.garage.addParkedCar(id,car);
        } else {
            return;
        }
    }

    public void unpark(int id){
        Car car = this.allCars.get(id);
        this.garage.removeParkedCar(id,car);
        this.allCars.put(id, car);
    }

    public boolean isInRace(int carId){
        Car car = this.allCars.get(carId);
        for (Race races : allRaces.values()) {
            if (races.getParticipants().contains(car)){
                return true;
            }
        }
        return false;
    }

    public void tune(int tuneIndex, String addOn){
        if (this.garage.getParkedCars().size() != 0){
            for (Car cars : this.garage.getParkedCars()) {
                cars.tune(tuneIndex, addOn);
            }
        }
    }
}
