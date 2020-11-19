package cardealer.service;

import cardealer.domain.dto.PartsSeedDto;
import cardealer.domain.entities.Part;
import cardealer.domain.entities.Supplier;
import cardealer.repository.PartRepository;
import cardealer.repository.SupplierRepository;
import cardealer.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PartServiceImpl implements PartService {
    private final PartRepository partRepository;
    private final SupplierRepository supplierRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper mapper;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, SupplierRepository supplierRepository, ValidatorUtil validatorUtil, ModelMapper mapper) {
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;
        this.validatorUtil = validatorUtil;
        this.mapper = mapper;
    }

    @Override
    public void seedParts(PartsSeedDto[] partsSeedDtos) {
        for (PartsSeedDto partsSeedDto : partsSeedDtos) {
            if (!this.validatorUtil.isValid(partsSeedDto)){
                this.validatorUtil.violations(partsSeedDto)
                        .forEach(violation -> System.out.println(violation.getMessage()));

                continue;
            }

            Part entity = this.mapper.map(partsSeedDto, Part.class);
            entity.setSupplier(this.getRandomSupplier());

            this.partRepository.saveAndFlush(entity);
        }
    }

    private Supplier getRandomSupplier(){
        Random random = new Random();

        return this.supplierRepository
                .getOne(random.nextInt((int)this.supplierRepository.count() - 1) + 1);
    }
}
