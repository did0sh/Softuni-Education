package cardealer.service;

import cardealer.domain.dto.CustomerOrderedByBirthDateView;
import cardealer.domain.dto.CustomerSeedDto;

import java.util.List;

public interface CustomerService {

    void seedCustomers(CustomerSeedDto[] customerSeedDtos);

    List<CustomerOrderedByBirthDateView> findAllCustomersOrderedByBirthDate();
}
