package cardealer.service;

import cardealer.domain.dto.LocalSupplierDto;
import cardealer.domain.dto.SupplierSeedDto;
import cardealer.domain.entities.Supplier;
import cardealer.repository.SupplierRepository;
import cardealer.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper mapper;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ValidatorUtil validatorUtil, ModelMapper mapper) {
        this.supplierRepository = supplierRepository;
        this.validatorUtil = validatorUtil;
        this.mapper = mapper;
    }

    @Override
    public void seedSuppliers(SupplierSeedDto[] supplierSeedDtos) {
        for (SupplierSeedDto supplierSeedDto : supplierSeedDtos) {
            if (!this.validatorUtil.isValid(supplierSeedDto)){
                this.validatorUtil.violations(supplierSeedDto)
                        .forEach(violation -> System.out.println(violation.getMessage()));

                continue;
            }

            Supplier supplier = this.mapper.map(supplierSeedDto, Supplier.class);

            this.supplierRepository.saveAndFlush(supplier);
        }
    }

    @Override
    public List<LocalSupplierDto> findAllLocalSuppliers() {
        List<Supplier> suppliers = this.supplierRepository.getAllSuppliers();

        List<LocalSupplierDto> localSupplierDtos = new ArrayList<>();

        for (Supplier supplier : suppliers) {
            LocalSupplierDto localSupplierDto = this.mapper.map(supplier, LocalSupplierDto.class);
            localSupplierDto.setPartsCount(supplier.getParts().size());

            localSupplierDtos.add(localSupplierDto);
        }

        return localSupplierDtos;
    }
}
