package cardealer.repository;

import cardealer.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findAllByMakeOrderByModel(String make);

    @Query(value = "SELECT c FROM cardealer.domain.entities.Car AS c")
    List<Car> getAllCarsWithParts();
}
