package cardealer.service;

import cardealer.domain.dto.seed.xml.CustomersCustomerDto;
import cardealer.domain.dto.view.xml.CustomersCustomerWithCarsAndMoneyDto;
import cardealer.domain.dto.view.xml.OrderedCustomersDto;

import java.util.List;

public interface CustomerService {

    void seedCustomers(CustomersCustomerDto customersCustomerDto);

    OrderedCustomersDto findAllCustomersOrderedByBirthDate();

    CustomersCustomerWithCarsAndMoneyDto findAllCustomersWithCarsAndSpentMoney();
}
