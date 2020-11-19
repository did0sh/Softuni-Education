package cardealer.service;

import cardealer.domain.dto.seed.CarSeedDto;
import cardealer.domain.dto.seed.xml.CarsCarDto;
import cardealer.domain.dto.view.CarIdMakeModelDistanceDto;
import cardealer.domain.dto.view.CarMakeModelDistanceParts;
import cardealer.domain.dto.view.PartNamePriceDto;
import cardealer.domain.dto.view.PartsPartDto;
import cardealer.domain.dto.view.xml.CarToyotaView;
import cardealer.domain.dto.view.xml.CarWithPartsViewDto;
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
    public void seedCars(CarsCarDto carsCarDto) {
        for (CarSeedDto carSeedDto : carsCarDto.getCarSeedDtos()) {
            if (!this.validatorUtil.isValid(carSeedDto)) {
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
    public CarToyotaView findAllCarsFromToyota() {
        List<Car> cars = this.carRepository.findAllByMakeOrderByModel("Toyota");

        List<CarIdMakeModelDistanceDto> carIdMakeModelDistanceDtos =
                new ArrayList<>();

        CarToyotaView carToyotaView = new CarToyotaView();

        for (Car car : cars) {
            CarIdMakeModelDistanceDto carIdMakeModelDistanceDto =
                    this.mapper.map(car, CarIdMakeModelDistanceDto.class);

            carIdMakeModelDistanceDtos.add(carIdMakeModelDistanceDto);
        }

        carToyotaView.setCarIdMakeModelDistanceDtos(carIdMakeModelDistanceDtos);
        return carToyotaView;
    }

    @Override
    public CarWithPartsViewDto findAllCarsWithParts() {
        List<Car> cars = this.carRepository.getAllCarsWithParts();

        List<PartNamePriceDto> partNamePriceDtos = new ArrayList<>();
        List<PartsPartDto> partsPartDtos = new ArrayList<>();
        List<CarMakeModelDistanceParts> carMakeModelDistanceParts = new ArrayList<>();

        Random random = new Random();

        for (Car car : cars) {

            for (Part part : car.getParts()) {
                PartNamePriceDto partNamePriceDto = new PartNamePriceDto();
                partNamePriceDto.setName(part.getName());
                partNamePriceDto.setPrice(part.getPrice());
                partNamePriceDtos.add(partNamePriceDto);
            }


            PartsPartDto partsPartDto = new PartsPartDto();
            partsPartDto.setPartNamePriceDtos(partNamePriceDtos);
            partsPartDtos.add(partsPartDto);

            CarMakeModelDistanceParts carMakeModelDistanceParts1 = new CarMakeModelDistanceParts();
            carMakeModelDistanceParts1.setMake(car.getMake());
            carMakeModelDistanceParts1.setModel(car.getModel());
            carMakeModelDistanceParts1.setTravelledDistance(car.getTravelledDistance());
            carMakeModelDistanceParts1.setPartsPartDtos(partsPartDtos);

            carMakeModelDistanceParts.add(carMakeModelDistanceParts1);

            partNamePriceDtos = new ArrayList<>();
            partsPartDtos = new ArrayList<>();
        }

        CarWithPartsViewDto carViews = new CarWithPartsViewDto();
        carViews.setCarMakeModelDistanceParts(carMakeModelDistanceParts);

        return carViews;
    }

    private List<Part> getRandomParts() {
        Random random = new Random();

        List<Part> parts = new ArrayList<>();

        int high = 20;
        int low = 10;

        int partsCount = random.nextInt(high - low) + low;

        for (int i = 0; i < partsCount; i++) {
            parts.add(this.partRepository.getOne(random.nextInt((int) this.partRepository.count() - 1) + 1));
        }

        return parts;
    }
}
