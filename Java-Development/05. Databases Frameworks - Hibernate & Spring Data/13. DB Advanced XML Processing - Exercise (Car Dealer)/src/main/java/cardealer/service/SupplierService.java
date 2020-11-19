package cardealer.service;

import cardealer.domain.dto.seed.xml.SuppliersSupplierDto;
import cardealer.domain.dto.view.xml.LocalSupplierDto;

public interface SupplierService {

    void seedSuppliers(SuppliersSupplierDto suppliersSupplierDto);

    LocalSupplierDto findAllLocalSuppliers();
}
