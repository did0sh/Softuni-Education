package cardealer.service;

import cardealer.domain.dto.seed.SupplierSeedDto;
import cardealer.domain.dto.seed.xml.SuppliersSupplierDto;
import cardealer.domain.dto.view.SupplierIdNamePartsCountDto;
import cardealer.domain.dto.view.xml.LocalSupplierDto;
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
    public void seedSuppliers(SuppliersSupplierDto suppliersSupplierDto) {
        for (SupplierSeedDto supplierSeedDto : suppliersSupplierDto.getSupplierSeedDtos()) {
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
    public LocalSupplierDto findAllLocalSuppliers() {
        List<Supplier> suppliers = this.supplierRepository.getAllSuppliers();

        List<SupplierIdNamePartsCountDto> supplierIdNamePartsCountDtos =
                new ArrayList<>();

        LocalSupplierDto localSupplierDto = new LocalSupplierDto();

        for (Supplier supplier : suppliers) {
            SupplierIdNamePartsCountDto supplierIdNamePartsCountDto =
                    this.mapper.map(supplier, SupplierIdNamePartsCountDto.class);

            supplierIdNamePartsCountDto.setPartsCount(supplier.getParts().size());

            supplierIdNamePartsCountDtos.add(supplierIdNamePartsCountDto);
        }

        localSupplierDto.setSupplierIdNamePartsCountDtos(supplierIdNamePartsCountDtos);
        return localSupplierDto;
    }
}
