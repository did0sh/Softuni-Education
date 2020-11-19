package cardealer.service;

import cardealer.domain.dto.LocalSupplierDto;
import cardealer.domain.dto.SupplierSeedDto;

import java.util.List;

public interface SupplierService {

    void seedSuppliers(SupplierSeedDto[] supplierSeedDtos);

    List<LocalSupplierDto> findAllLocalSuppliers();
}
