package org.softuni.cardealer.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.cardealer.domain.entities.*;
import org.softuni.cardealer.domain.models.service.*;
import org.softuni.cardealer.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class SaleServiceTests {

    @Autowired
    private CarSaleRepository carSaleRepository;
    @Autowired
    private PartSaleRepository partSaleRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private PartRepository partRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SupplierRepository supplierRepository;


    private ModelMapper modelMapper;
    private PartSale partSale;
    private CarSale carSale;
    private Car car;
    private Customer customer;
    private Part part;
    private Supplier supplier;

    @Before
    public void init() {
        this.modelMapper = new ModelMapper();
        partSale = new PartSale() {{
            setQuantity(100);
            setDiscount(15.00);
        }};
        carSale = new CarSale() {{
            setDiscount(16.00);
        }};
        car = new Car() {{
            setMake("Renault");
            setModel("Clio");
            setTravelledDistance(200000L);
            setParts(null);
        }};
        customer = new Customer() {{
            setBirthDate(LocalDate.of(1998, 12, 12));
            setYoungDriver(true);
            setName("Ismail");
        }};
        part = new Part() {{
            setPrice(BigDecimal.valueOf(100));
            setName("Test Part");
        }};
        supplier = new Supplier() {{
            setName("Gosho");
            setImporter(true);
        }};
    }

    @Test()
    public void saleService_saleCar_ShouldReturnCorrect() {
        CarService carService = new CarServiceImpl(carRepository, modelMapper);

        CarServiceModel savedCar = carService.saveCar(this.modelMapper.map(car, CarServiceModel.class));
        car.setId(savedCar.getId());

        CustomerService customerService = new CustomerServiceImpl(customerRepository, modelMapper);

        CustomerServiceModel savedCustomer = customerService.saveCustomer(this.modelMapper.map(customer, CustomerServiceModel.class));
        customer.setId(savedCustomer.getId());

        CarSaleServiceModel carSaleServiceModel = new CarSaleServiceModel() {{
            setCar(savedCar);
            setCustomer(savedCustomer);
            setDiscount(carSale.getDiscount());
        }};

        SaleService saleService = new SaleServiceImpl(carSaleRepository, partSaleRepository, modelMapper);
        CarSaleServiceModel saledCar = saleService.saleCar(carSaleServiceModel);

        Assert.assertEquals(saledCar.getCar().getId(), carSaleServiceModel.getCar().getId());
        Assert.assertEquals(saledCar.getCustomer().getId(), carSaleServiceModel.getCustomer().getId());
        Assert.assertEquals(saledCar.getDiscount(), carSaleServiceModel.getDiscount());
    }

    @Test(expected = Exception.class)
    public void saleService_saleCarWithNullValues_ShouldThrowException() {
        CarService carService = new CarServiceImpl(carRepository, modelMapper);

        CarServiceModel savedCar = carService.saveCar(this.modelMapper.map(car, CarServiceModel.class));
        car.setId(savedCar.getId());

        CustomerService customerService = new CustomerServiceImpl(customerRepository, modelMapper);

        CustomerServiceModel savedCustomer = customerService.saveCustomer(this.modelMapper.map(customer, CustomerServiceModel.class));
        customer.setId(savedCustomer.getId());

        CarSaleServiceModel carSaleServiceModel = new CarSaleServiceModel() {{
            setCar(savedCar);
            setCustomer(savedCustomer);
            setDiscount(null);
        }};

        SaleService saleService = new SaleServiceImpl(carSaleRepository, partSaleRepository, modelMapper);
        saleService.saleCar(carSaleServiceModel);
    }

    @Test()
    public void saleService_salePart_ShouldReturnCorrect() {
        SupplierService supplierService = new SupplierServiceImpl(supplierRepository, modelMapper);
        supplierService.saveSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));

        PartService partService = new PartServiceImpl(partRepository, modelMapper);

        PartServiceModel savedPart = partService.savePart(this.modelMapper.map(part, PartServiceModel.class));
        part.setSupplier(supplier);
        part.setId(savedPart.getId());

        CustomerService customerService = new CustomerServiceImpl(customerRepository, modelMapper);

        CustomerServiceModel savedCustomer = customerService.saveCustomer(this.modelMapper.map(customer, CustomerServiceModel.class));
        customer.setId(savedCustomer.getId());

        PartSaleServiceModel partSaleServiceModel = new PartSaleServiceModel() {{
            setDiscount(partSale.getDiscount());
            setQuantity(partSale.getQuantity());
            setPart(modelMapper.map(part, PartServiceModel.class));
            setCustomer(modelMapper.map(customer, CustomerServiceModel.class));
            setId(part.getId());
        }};

        SaleService saleService = new SaleServiceImpl(carSaleRepository, partSaleRepository, modelMapper);
        PartSaleServiceModel saledPart = saleService.salePart(partSaleServiceModel);

        Assert.assertEquals(saledPart.getPart().getId(), partSaleServiceModel.getPart().getId());
        Assert.assertEquals(saledPart.getCustomer().getId(), partSaleServiceModel.getCustomer().getId());
        Assert.assertEquals(saledPart.getDiscount(), partSaleServiceModel.getDiscount());
        Assert.assertEquals(saledPart.getQuantity(), partSaleServiceModel.getQuantity());
    }

    @Test(expected = Exception.class)
    public void saleService_salePartWithNullValues_ShouldThrowException() {
        SupplierService supplierService = new SupplierServiceImpl(supplierRepository, modelMapper);
        supplierService.saveSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));

        PartService partService = new PartServiceImpl(partRepository, modelMapper);

        PartServiceModel savedPart = partService.savePart(this.modelMapper.map(part, PartServiceModel.class));
        part.setSupplier(supplier);
        part.setId(savedPart.getId());

        CustomerService customerService = new CustomerServiceImpl(customerRepository, modelMapper);

        CustomerServiceModel savedCustomer = customerService.saveCustomer(this.modelMapper.map(customer, CustomerServiceModel.class));
        customer.setId(savedCustomer.getId());

        PartSaleServiceModel partSaleServiceModel = new PartSaleServiceModel() {{
            setDiscount(partSale.getDiscount());
            setQuantity(null);
            setPart(modelMapper.map(part, PartServiceModel.class));
            setCustomer(modelMapper.map(customer, CustomerServiceModel.class));
            setId(null);
        }};

        SaleService saleService = new SaleServiceImpl(carSaleRepository, partSaleRepository, modelMapper);
        PartSaleServiceModel saledPart = saleService.salePart(partSaleServiceModel);

        Assert.assertEquals(saledPart.getPart().getId(), partSaleServiceModel.getPart().getId());
        Assert.assertEquals(saledPart.getCustomer().getId(), partSaleServiceModel.getCustomer().getId());
        Assert.assertEquals(saledPart.getDiscount(), partSaleServiceModel.getDiscount());
        Assert.assertEquals(saledPart.getQuantity(), partSaleServiceModel.getQuantity());
    }

    @Test(expected = Exception.class)
    public void saleService_salePartWithoutSavingEntitiesFirst_ShouldThrowException() {
        // No customer saved
        PartService partService = new PartServiceImpl(partRepository, modelMapper);

        PartServiceModel savedPart = partService.savePart(this.modelMapper.map(part, PartServiceModel.class));
        part.setId(savedPart.getId());

//        CustomerService customerService = new CustomerServiceImpl(customerRepository, modelMapper);
//
//        CustomerServiceModel savedCustomer = customerService.saveCustomer(this.modelMapper.map(customer, CustomerServiceModel.class));
//        customer.setId(savedCustomer.getId());

        PartSaleServiceModel partSaleServiceModel = new PartSaleServiceModel() {{
            setDiscount(partSale.getDiscount());
            setQuantity(150);
            setPart(modelMapper.map(part, PartServiceModel.class));
            setCustomer(modelMapper.map(customer, CustomerServiceModel.class));
            setId(part.getId());
        }};

        SaleService saleService = new SaleServiceImpl(carSaleRepository, partSaleRepository, modelMapper);
        saleService.salePart(partSaleServiceModel);
    }
}