package cardealer.service;

import cardealer.domain.dto.seed.CustomerSeedDto;
import cardealer.domain.dto.seed.xml.CustomersCustomerDto;
import cardealer.domain.dto.view.CustomerIdNameBirthDateYoungDriverDto;
import cardealer.domain.dto.view.CustomerNameCarsSpentMoney;
import cardealer.domain.dto.view.xml.CustomersCustomerWithCarsAndMoneyDto;
import cardealer.domain.dto.view.xml.OrderedCustomersDto;
import cardealer.domain.entities.Customer;
import cardealer.repository.CustomerRepository;
import cardealer.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper mapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ValidatorUtil validatorUtil, ModelMapper mapper) {
        this.customerRepository = customerRepository;
        this.validatorUtil = validatorUtil;
        this.mapper = mapper;
    }

    @Override
    public void seedCustomers(CustomersCustomerDto customersCustomerDto) {
        for (CustomerSeedDto customerSeedDto : customersCustomerDto.getCustomerSeedDtos()) {
            if (!this.validatorUtil.isValid(customerSeedDto)){
                this.validatorUtil.violations(customerSeedDto)
                        .forEach(violation -> System.out.println(violation.getMessage()));

                continue;
            }

            Customer entity = this.mapper.map(customerSeedDto, Customer.class);

            this.customerRepository.saveAndFlush(entity);
        }
    }

    @Override
    public OrderedCustomersDto findAllCustomersOrderedByBirthDate() {
        List<Customer> customers= this.customerRepository.getAllByBirthDate();

        List<CustomerIdNameBirthDateYoungDriverDto> customerIdNameBirthDateYoungDriverDtos
                = new ArrayList<>();

        OrderedCustomersDto orderedCustomersDto = new OrderedCustomersDto();

        for (Customer customer : customers) {
            CustomerIdNameBirthDateYoungDriverDto
                    customerIdNameBirthDateYoungDriverDto =
                    this.mapper.map(customer, CustomerIdNameBirthDateYoungDriverDto.class);

            customerIdNameBirthDateYoungDriverDtos.add(customerIdNameBirthDateYoungDriverDto);
        }

        orderedCustomersDto.setCustomerIdNameBirthDateYoungDriverDtos(customerIdNameBirthDateYoungDriverDtos);
        return orderedCustomersDto;
    }

    @Override
    public CustomersCustomerWithCarsAndMoneyDto findAllCustomersWithCarsAndSpentMoney() {
        List<Customer> customers= this.customerRepository.getAllWithMoreThan1Car();

        List<CustomerNameCarsSpentMoney> customerNameCarsSpentMonies
                = new ArrayList<>();

        CustomersCustomerWithCarsAndMoneyDto cutomersCustomerDto = new CustomersCustomerWithCarsAndMoneyDto();

        for (Customer customer : customers) {
            CustomerNameCarsSpentMoney
                    customerNameCarsSpentMoney =
                    this.mapper.map(customer, CustomerNameCarsSpentMoney.class);

            customerNameCarsSpentMoney.setBoughtCars(customer.getPurchases().size());

            BigDecimal spentMoney = BigDecimal.ZERO;

            for (int i = 0; i < customer.getPurchases().size(); i++) {
                for (int j = 0; j < customer.getPurchases().get(i).getCar().getParts().size(); j++) {
                    spentMoney = spentMoney.add(customer.getPurchases().get(i)
                            .getCar().getParts().get(j).getPrice());
                }
            }

            customerNameCarsSpentMoney.setSpentMoney(spentMoney);
            customerNameCarsSpentMonies.add(customerNameCarsSpentMoney);
        }

        cutomersCustomerDto.setCustomerNameCarsSpentMonies(customerNameCarsSpentMonies);
        return cutomersCustomerDto;
    }
}
