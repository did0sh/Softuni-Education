package cardealer.service;

import cardealer.domain.dto.CarSeedDto;
import cardealer.domain.dto.CarToyotaView;
import cardealer.domain.dto.CarWithPartsViewDto;

import java.util.List;

public interface CarService {

    void seedCars(CarSeedDto[] carSeedDtos);

    List<CarToyotaView> findAllCarsFromToyota();

    List<CarWithPartsViewDto> findAllCarsWithParts();
}
