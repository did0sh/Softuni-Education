package org.softuni.cardealer.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.cardealer.domain.entities.Customer;
import org.softuni.cardealer.domain.models.service.CustomerServiceModel;
import org.softuni.cardealer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CustomerServiceTests {

    @Autowired
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;
    private Customer customer;

    @Before
    public void init() {
        this.modelMapper = new ModelMapper();
        customer = new Customer() {{
            setBirthDate(LocalDate.of(2012, 12, 26));
            setName("Pesho");
            setYoungDriver(true);
        }};
    }

    @Test
    public void customerService_saveCustomer_ShouldReturnCorrect() {
        CustomerServiceImpl service = new CustomerServiceImpl(customerRepository, modelMapper);
        CustomerServiceModel savedCustomer =
                service.saveCustomer(this.modelMapper.map(customer, CustomerServiceModel.class));
        customer.setId(savedCustomer.getId());

        Assert.assertEquals(customer.getId(), savedCustomer.getId());
        Assert.assertEquals(customer.getBirthDate(), savedCustomer.getBirthDate());
        Assert.assertEquals(customer.getName(), savedCustomer.getName());
        Assert.assertEquals(customer.isYoungDriver(), savedCustomer.isYoungDriver());
    }

    @Test(expected = Exception.class)
    public void customerService_saveCustomerWithNullValues_ShouldThrowException() {
        customer.setBirthDate(null);
        CustomerServiceImpl service = new CustomerServiceImpl(customerRepository, modelMapper);
        service.saveCustomer(this.modelMapper.map(customer, CustomerServiceModel.class));
    }

    @Test
    public void customerService_editCustomer_ShouldReturnCorrect() {
        CustomerServiceImpl service = new CustomerServiceImpl(customerRepository, modelMapper);
        CustomerServiceModel savedCustomer =
                service.saveCustomer(this.modelMapper.map(customer, CustomerServiceModel.class));
        customer.setId(savedCustomer.getId());

        CustomerServiceModel editCustomer = new CustomerServiceModel() {{
            setBirthDate(LocalDate.of(1999, 2, 13));
            setName("Edited Customer");
            setYoungDriver(false);
            setId(customer.getId());
        }};

        CustomerServiceModel changedCustomer = service.editCustomer(editCustomer);

        Assert.assertEquals(changedCustomer.getId(), editCustomer.getId());
        Assert.assertEquals(changedCustomer.getBirthDate(), editCustomer.getBirthDate());
        Assert.assertEquals(changedCustomer.getName(), editCustomer.getName());
        Assert.assertEquals(changedCustomer.isYoungDriver(), editCustomer.isYoungDriver());
    }

    @Test(expected = Exception.class)
    public void customerService_editCustomerWithoutId_ShouldThrowException() {
        CustomerServiceImpl service = new CustomerServiceImpl(customerRepository, modelMapper);
        CustomerServiceModel savedCustomer =
                service.saveCustomer(this.modelMapper.map(customer, CustomerServiceModel.class));
        customer.setId(savedCustomer.getId());

        CustomerServiceModel editCustomer = new CustomerServiceModel() {{
            setBirthDate(LocalDate.of(1999, 2, 13));
            setName("Edited Customer");
            setYoungDriver(false);
            setId(null);
        }};

        service.editCustomer(editCustomer);
    }

    @Test
    public void customerService_deleteCustomer_ShouldReturnCorrect() {
        CustomerServiceImpl service = new CustomerServiceImpl(customerRepository, modelMapper);
        CustomerServiceModel savedCustomer =
                service.saveCustomer(this.modelMapper.map(customer, CustomerServiceModel.class));
        customer.setId(savedCustomer.getId());

        String customerToDeleteID = customer.getId();
        service.deleteCustomer(customerToDeleteID);

        Assert.assertEquals(this.customerRepository.count(), 0);
    }

    @Test(expected = Exception.class)
    public void customerService_deleteCustomerWithFalseId_ShouldThrowException() {
        CustomerServiceImpl service = new CustomerServiceImpl(customerRepository, modelMapper);
        CustomerServiceModel savedCustomer =
                service.saveCustomer(this.modelMapper.map(customer, CustomerServiceModel.class));
        customer.setId(savedCustomer.getId());

        service.deleteCustomer("False id");
    }

    @Test
    public void customerService_findCustomerById_ShouldReturnCorrect() {
        CustomerServiceImpl service = new CustomerServiceImpl(customerRepository, modelMapper);
        CustomerServiceModel savedCustomer =
                service.saveCustomer(this.modelMapper.map(customer, CustomerServiceModel.class));
        customer.setId(savedCustomer.getId());

        String customerToDeleteID = customer.getId();
        CustomerServiceModel foundCustomer = service.findCustomerById(customerToDeleteID);

        Assert.assertEquals(savedCustomer.getId(), foundCustomer.getId());
        Assert.assertEquals(savedCustomer.getBirthDate(), foundCustomer.getBirthDate());
        Assert.assertEquals(savedCustomer.getName(), foundCustomer.getName());
        Assert.assertEquals(savedCustomer.isYoungDriver(), foundCustomer.isYoungDriver());
    }

    @Test(expected = Exception.class)
    public void customerService_findCustomerByFalseId_ShouldThrowException() {
        CustomerServiceImpl service = new CustomerServiceImpl(customerRepository, modelMapper);
        CustomerServiceModel savedCustomer =
                service.saveCustomer(this.modelMapper.map(customer, CustomerServiceModel.class));
        customer.setId(savedCustomer.getId());

        service.findCustomerById("False id");
    }
}
