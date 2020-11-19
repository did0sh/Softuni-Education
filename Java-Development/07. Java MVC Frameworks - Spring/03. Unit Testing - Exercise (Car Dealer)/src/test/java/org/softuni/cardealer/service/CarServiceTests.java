package org.softuni.cardealer.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.cardealer.domain.entities.Car;
import org.softuni.cardealer.domain.models.service.CarServiceModel;
import org.softuni.cardealer.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CarServiceTests {

    @Autowired
    private CarRepository carRepository;
    private ModelMapper modelMapper;
    private Car car;

    @Before
    public void init(){
        this.modelMapper = new ModelMapper();
        car = new Car() {{
            setMake("Mercedes");
            setModel("C220");
            setTravelledDistance(14000L);
        }};
    }

    @Test
    public void carService_saveCar_ShouldReturnCorrect(){
        CarService service = new CarServiceImpl(carRepository, modelMapper);
        CarServiceModel savedCar = service.saveCar(this.modelMapper.map(car, CarServiceModel.class));
        car.setId(savedCar.getId());

        Assert.assertEquals(car.getId(), savedCar.getId());
        Assert.assertEquals(car.getTravelledDistance(), savedCar.getTravelledDistance());
        Assert.assertEquals(car.getModel(), savedCar.getModel());
        Assert.assertEquals(car.getMake(), savedCar.getMake());
    }

    @Test(expected = Exception.class)
    public void carService_saveCarWithNullValues_ShouldThrowException(){
        car.setModel(null);
        CarService service = new CarServiceImpl(carRepository, modelMapper);
        CarServiceModel savedCar = service.saveCar(this.modelMapper.map(car, CarServiceModel.class));
    }

    @Test
    public void carService_editCar_ShouldReturnCorrect(){
        CarService service = new CarServiceImpl(carRepository, modelMapper);
        CarServiceModel savedCar = service.saveCar(this.modelMapper.map(car, CarServiceModel.class));
        car.setId(savedCar.getId());

        CarServiceModel editCar = new CarServiceModel() {{
            setMake("Opel");
            setModel("Insignia");
            setTravelledDistance(15000L);
            setId(car.getId());
        }};

        CarServiceModel changedCar = service.editCar(editCar);

        Assert.assertEquals(changedCar.getId(), editCar.getId());
        Assert.assertEquals(changedCar.getTravelledDistance(), editCar.getTravelledDistance());
        Assert.assertEquals(changedCar.getModel(), editCar.getModel());
        Assert.assertEquals(changedCar.getMake(), editCar.getMake());
    }

    @Test(expected = Exception.class)
    public void carService_editCarWithoutId_ShouldThrowException(){
        CarService service = new CarServiceImpl(carRepository, modelMapper);
        CarServiceModel savedCar = service.saveCar(this.modelMapper.map(car, CarServiceModel.class));
        car.setId(savedCar.getId());

        CarServiceModel editCar = new CarServiceModel() {{
            setMake("Opel");
            setModel("Insignia");
            setTravelledDistance(15000L);
            setId(null);
        }};

        service.editCar(editCar);
    }

    @Test
    public void carService_deleteCar_ShouldReturnCorrect(){
        CarService service = new CarServiceImpl(carRepository, modelMapper);
        CarServiceModel savedCar = service.saveCar(this.modelMapper.map(car, CarServiceModel.class));
        car.setId(savedCar.getId());

        String carToDeleteId = car.getId();
        service.deleteCar(carToDeleteId);

        Assert.assertEquals(this.carRepository.count(), 0);
    }

    @Test(expected = Exception.class)
    public void carService_deleteCarWithFalseId_ShouldThrowException(){
        CarService service = new CarServiceImpl(carRepository, modelMapper);
        CarServiceModel savedCar = service.saveCar(this.modelMapper.map(car, CarServiceModel.class));
        car.setId(savedCar.getId());

        service.deleteCar("False id");
    }
}
