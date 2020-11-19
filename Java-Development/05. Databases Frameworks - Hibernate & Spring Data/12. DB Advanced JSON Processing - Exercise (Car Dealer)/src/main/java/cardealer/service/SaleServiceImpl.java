package cardealer.service;

import cardealer.domain.dto.SaleSeedDto;
import cardealer.domain.entities.Car;
import cardealer.domain.entities.Customer;
import cardealer.domain.entities.Sale;
import cardealer.repository.CarRepository;
import cardealer.repository.CustomerRepository;
import cardealer.repository.SaleRepository;
import cardealer.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SaleServiceImpl implements SaleService {
    private final CustomerRepository customerRepository;
    private final CarRepository carRepository;
    private final SaleRepository saleRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper mapper;

    @Autowired
    public SaleServiceImpl(CustomerRepository customerRepository, CarRepository carRepository, SaleRepository saleRepository, ValidatorUtil validatorUtil, ModelMapper mapper) {
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
        this.saleRepository = saleRepository;
        this.validatorUtil = validatorUtil;
        this.mapper = mapper;
    }

    @Override
    public void seedSales() {
        for (int i = 0; i < 50; i++) {
            Sale entity = new Sale();

            for (int j = 0; j < this.carRepository.count(); j++) {
                entity.setCar(this.getRandomCar());
            }

            for (int k = 0; k < this.customerRepository.count(); k++) {
                entity.setCustomer(this.getRandomCustomer());
            }


            entity.setDiscount(this.getRandomDiscount());

            this.saleRepository.saveAndFlush(entity);
        }
    }


    private Car getRandomCar() {
        Random random = new Random();

        return this.carRepository
                .getOne(random.nextInt((int) this.carRepository.count() - 1) + 1);
    }

    private Customer getRandomCustomer() {
        Random random = new Random();

        return this.customerRepository
                .getOne(random.nextInt((int) this.customerRepository.count() - 1) + 1);
    }


    private Double getRandomDiscount() {
        Random random = new Random();

        return random.nextDouble();
    }
}
