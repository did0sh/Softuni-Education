package cardealer.service;

import cardealer.domain.dto.PartsSeedDto;

public interface PartService {

    void seedParts(PartsSeedDto[] partsSeedDtos);
}
