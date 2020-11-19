package cardealer.service;

import cardealer.domain.dto.CarSeedDto;
import cardealer.domain.dto.CarToyotaView;
import cardealer.domain.dto.CarWithPartsViewDto;
import cardealer.domain.dto.PartsViewDto;
import cardealer.domain.entities.Car;
import cardealer.domain.entities.Part;
import cardealer.repository.CarRepository;
import cardealer.repository.PartRepository;
import cardealer.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper mapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartRepository partRepository, ValidatorUtil validatorUtil, ModelMapper mapper) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.validatorUtil = validatorUtil;
        this.mapper = mapper;
    }

    @Override
    public void seedCars(CarSeedDto[] carSeedDtos) {
        for (CarSeedDto carSeedDto : carSeedDtos) {
            if (!this.validatorUtil.isValid(carSeedDto)){
                this.validatorUtil.violations(carSeedDto)
                        .forEach(violation -> System.out.println(violation.getMessage()));

                continue;
            }

            Car entity = this.mapper.map(carSeedDto, Car.class);
            entity.setParts(this.getRandomParts());

            this.carRepository.saveAndFlush(entity);
        }
    }

    @Override
    public List<CarToyotaView> findAllCarsFromToyota() {
        List<Car> cars = this.carRepository.findAllByMakeOrderByModel("Toyota");

        List<CarToyotaView> carToyotaViews = new ArrayList<>();

        for (Car car : cars) {
            CarToyotaView carToyotaView = this.mapper.map(car, CarToyotaView.class);

            carToyotaViews.add(carToyotaView);
        }
        return carToyotaViews;
    }

    @Override
    public List<CarWithPartsViewDto> findAllCarsWithParts() {
        List<Car> cars = this.carRepository.getAllCarsWithParts();

        List<CarWithPartsViewDto> carViews = new ArrayList<>();

        for (Car car : cars) {
            CarWithPartsViewDto carView = this.mapper.map(car, CarWithPartsViewDto.class);
            List<Part> currentParts = car.getParts();

            List<PartsViewDto> partsViewDtos = new ArrayList<>();
            for (Part currentPart : currentParts) {
                PartsViewDto partsViewDto = this.mapper.map(currentPart, PartsViewDto.class);

                partsViewDtos.add(partsViewDto);
            }

            carView.setParts(partsViewDtos);
            carViews.add(carView);
        }

        return carViews;
    }

    private List<Part> getRandomParts(){
        Random random = new Random();

        List<Part> parts = new ArrayList<>();

        int high = 20;
        int low = 10;

        int partsCount = random.nextInt(high - low) + low;

        for (int i = 0; i < partsCount ; i++) {
            parts.add(this.partRepository.getOne(random.nextInt((int)this.partRepository.count() - 1) + 1));
        }

        return parts;
    }
}
