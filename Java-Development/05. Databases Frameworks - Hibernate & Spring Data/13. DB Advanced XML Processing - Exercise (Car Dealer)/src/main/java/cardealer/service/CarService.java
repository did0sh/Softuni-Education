package cardealer.service;

import cardealer.domain.dto.seed.xml.CarsCarDto;
import cardealer.domain.dto.view.xml.CarToyotaView;
import cardealer.domain.dto.view.xml.CarWithPartsViewDto;

public interface CarService {

    void seedCars(CarsCarDto carsCarDto);

    CarToyotaView findAllCarsFromToyota();

    CarWithPartsViewDto findAllCarsWithParts();
}
