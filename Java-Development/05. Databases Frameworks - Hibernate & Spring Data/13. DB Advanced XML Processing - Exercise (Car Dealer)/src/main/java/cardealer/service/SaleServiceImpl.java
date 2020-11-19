package cardealer.service;

import cardealer.domain.dto.view.CarMakeModelDistanceCustomerDiscountPriceDto;
import cardealer.domain.dto.view.SaleView;
import cardealer.domain.dto.view.xml.SaleViewDto;
import cardealer.domain.entities.Car;
import cardealer.domain.entities.Customer;
import cardealer.domain.entities.Part;
import cardealer.domain.entities.Sale;
import cardealer.repository.CarRepository;
import cardealer.repository.CustomerRepository;
import cardealer.repository.SaleRepository;
import cardealer.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
        for (int i = 0; i < 20; i++) {
            Sale entity = new Sale();

            entity.setCar(this.getRandomCar());
            entity.setCustomer(this.getRandomCustomer());
            entity.setDiscount(this.getRandomDiscount());

            this.saleRepository.saveAndFlush(entity);
        }
    }

    @Override
    public SaleViewDto getSales() {
        List<Sale> sales= this.saleRepository.getAllSales();

        List<CarMakeModelDistanceCustomerDiscountPriceDto> carMakeModelDistanceCustomerDiscountPriceDtos
                = new ArrayList<>();

        List<SaleView> saleViews = new ArrayList<>();

        SaleViewDto saleViewDto = new SaleViewDto();

        for (Sale sale : sales) {
            CarMakeModelDistanceCustomerDiscountPriceDto carMakeModelDistanceCustomerDiscountPriceDto =
                    new CarMakeModelDistanceCustomerDiscountPriceDto();

            carMakeModelDistanceCustomerDiscountPriceDto.setDistance(sale.getCar().getTravelledDistance());
            carMakeModelDistanceCustomerDiscountPriceDto.setMake(sale.getCar().getMake());
            carMakeModelDistanceCustomerDiscountPriceDto.setModel(sale.getCar().getModel());
            carMakeModelDistanceCustomerDiscountPriceDto.setCustomerName(sale.getCustomer().getName());
            carMakeModelDistanceCustomerDiscountPriceDto.setDiscount(sale.getDiscount());
            carMakeModelDistanceCustomerDiscountPriceDto
                    .setPrice(sale.getCar().getParts()
                            .stream().map(Part::getPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO));
            carMakeModelDistanceCustomerDiscountPriceDto
                    .setPriceWithDiscount
                            (carMakeModelDistanceCustomerDiscountPriceDto.getPrice()
                                    .multiply(BigDecimal.valueOf(carMakeModelDistanceCustomerDiscountPriceDto.getDiscount())));

            carMakeModelDistanceCustomerDiscountPriceDtos.add(carMakeModelDistanceCustomerDiscountPriceDto);


            SaleView saleView = new SaleView();
            saleView.setCarMakeModelDistanceCustomerDiscountPriceDtos(carMakeModelDistanceCustomerDiscountPriceDtos);

            saleViews.add(saleView);
        }

        saleViewDto.setSaleViews(saleViews);
        return saleViewDto;
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

        return (random.nextInt(10) * 5) / 100.0;
    }
}
