package cardealer.service;

import cardealer.domain.dto.CustomerOrderedByBirthDateView;
import cardealer.domain.dto.CustomerSeedDto;
import cardealer.domain.entities.Customer;
import cardealer.repository.CustomerRepository;
import cardealer.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
    public void seedCustomers(CustomerSeedDto[] customerSeedDtos) {
        for (CustomerSeedDto customerSeedDto : customerSeedDtos) {
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
    public List<CustomerOrderedByBirthDateView> findAllCustomersOrderedByBirthDate() {
        List<Customer> customers= this.customerRepository.getAllByBirthDate();

        List<CustomerOrderedByBirthDateView> customerOrderedByBirthDateViews
                = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerOrderedByBirthDateView
                    customerBirthDate = this.mapper.map(customer, CustomerOrderedByBirthDateView.class);

            customerOrderedByBirthDateViews.add(customerBirthDate);
        }
        return customerOrderedByBirthDateViews;
    }
}
