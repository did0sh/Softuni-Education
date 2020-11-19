package exam;

import java.util.*;

public class Garage {
    private Collection <Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public void addParkedCar(int id,Car car){
        this.parkedCars.add(car);
    }

    public void removeParkedCar(int id,Car car){
        this.parkedCars.remove(car);
    }

    public Collection<Car> getParkedCars() {
        return Collections.unmodifiableCollection(this.parkedCars);
    }
}
