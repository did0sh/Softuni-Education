package cardealer.web;

import cardealer.domain.dto.seed.xml.CarsCarDto;
import cardealer.domain.dto.seed.xml.CustomersCustomerDto;
import cardealer.domain.dto.seed.xml.PartsPartDto;
import cardealer.domain.dto.seed.xml.SuppliersSupplierDto;
import cardealer.domain.dto.view.xml.*;
import cardealer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import javax.xml.bind.*;
import java.io.*;

@org.springframework.stereotype.Controller
public class Controller implements CommandLineRunner {
    private static final String SUPPLIER_FILE_PATH = "/files/suppliers.xml";
    private static final String PART_FILE_PATH = "/files/parts.xml";
    private static final String CAR_FILE_PATH = "/files/cars.xml";
    private static final String CUSTOMER_FILE_PATH = "/files/customers.xml";

    private static final String ORDERED_CUSTOMERS_OUTPUT = "C:\\Users\\user\\Downloads\\hw\\13. DB Advanced XML Processing - Exercise (Car Dealer)\\src\\main\\resources\\output\\ordered-customers.xml";
    private static final String CAR_TOYOTA_OUTPUT = "C:\\Users\\user\\Downloads\\hw\\13. DB Advanced XML Processing - Exercise (Car Dealer)\\src\\main\\resources\\output\\ordered-customers.xml";
    private static final String LOCAL_SUPPLIER_OUTPUT = "C:\\Users\\user\\Downloads\\hw\\13. DB Advanced XML Processing - Exercise (Car Dealer)\\src\\main\\resources\\output\\local-suppliers.xml";
    private static final String CAR_WITH_PARTS_OUTPUT = "C:\\Users\\user\\Downloads\\hw\\13. DB Advanced XML Processing - Exercise (Car Dealer)\\src\\main\\resources\\output\\car-with-parts.xml";
    private static final String CUSTOMERS_WITH_CARS_MONEY = "C:\\Users\\user\\Downloads\\hw\\13. DB Advanced XML Processing - Exercise (Car Dealer)\\src\\main\\resources\\output\\customers-with-cars-money.xml";
    private static final String SALES_OUTPUT = "C:\\Users\\user\\Downloads\\hw\\13. DB Advanced XML Processing - Exercise (Car Dealer)\\src\\main\\resources\\output\\sales.xml";

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;

    @Autowired
    public Controller(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {
        //this.seedSuppliers();

        //this.seedParts();

        //this.seedCars();

        //this.seedCustomers();

        //this.seedSales();

        //Query 1
        //this.addCustomersToFile();

        //Query 2
        //this.addToyotaCarsToFile();

        //Query 3
        //this.addSuppliersToFile();

        //Query 4
        //this.addCarsWithPartsToFile();

        //Query 5
        //this.addCustomersWithCarsAndSpentMoneyToFile();

        //Query 6
        this.addSalesToFile();
    }

    private void seedSuppliers() throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(SuppliersSupplierDto.class);

        InputStream inputStream = getClass().getResourceAsStream(SUPPLIER_FILE_PATH);
        BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        SuppliersSupplierDto suppliersSupplierDto = (SuppliersSupplierDto) unmarshaller.unmarshal(bfr);

        this.supplierService.seedSuppliers(suppliersSupplierDto);
    }

    private void seedParts() throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PartsPartDto.class);

        InputStream inputStream = getClass().getResourceAsStream(PART_FILE_PATH);
        BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        PartsPartDto partsPartDto = (PartsPartDto) unmarshaller.unmarshal(bfr);

        this.partService.seedParts(partsPartDto);
    }

    private void seedCars() throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CarsCarDto.class);

        InputStream inputStream = getClass().getResourceAsStream(CAR_FILE_PATH);
        BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        CarsCarDto carsCarDto = (CarsCarDto) unmarshaller.unmarshal(bfr);

        this.carService.seedCars(carsCarDto);
    }

    private void seedCustomers() throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CustomersCustomerDto.class);

        InputStream inputStream = getClass().getResourceAsStream(CUSTOMER_FILE_PATH);
        BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        CustomersCustomerDto customersCustomerDto = (CustomersCustomerDto) unmarshaller.unmarshal(bfr);

        this.customerService.seedCustomers(customersCustomerDto);
    }

    private void seedSales() throws IOException {

        this.saleService.seedSales();
    }

    private void addCustomersToFile() throws IOException, JAXBException {
        OrderedCustomersDto customerOrderedByBirthDateViewList
                = this.customerService.findAllCustomersOrderedByBirthDate();

        JAXBContext jaxbContext = JAXBContext.newInstance(OrderedCustomersDto.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        OutputStream outputStream = new FileOutputStream(ORDERED_CUSTOMERS_OUTPUT);
        BufferedWriter bfw =
                new BufferedWriter(new OutputStreamWriter(outputStream));

        jaxbMarshaller.marshal(customerOrderedByBirthDateViewList, bfw);

    }

    private void addToyotaCarsToFile() throws IOException, JAXBException {
        CarToyotaView carToyotaView = this.carService.findAllCarsFromToyota();

        JAXBContext jaxbContext = JAXBContext.newInstance(CarToyotaView.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        OutputStream outputStream = new FileOutputStream(CAR_TOYOTA_OUTPUT);
        BufferedWriter bfw =
                new BufferedWriter(new OutputStreamWriter(outputStream));

        jaxbMarshaller.marshal(carToyotaView, bfw);
    }

    private void addSuppliersToFile() throws IOException, JAXBException {
        LocalSupplierDto localSupplierDto =
                this.supplierService.findAllLocalSuppliers();

        JAXBContext jaxbContext = JAXBContext.newInstance(LocalSupplierDto.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        OutputStream outputStream = new FileOutputStream(LOCAL_SUPPLIER_OUTPUT);
        BufferedWriter bfw =
                new BufferedWriter(new OutputStreamWriter(outputStream));

        jaxbMarshaller.marshal(localSupplierDto, bfw);
    }

    private void addCarsWithPartsToFile() throws IOException, JAXBException {
        CarWithPartsViewDto carWithPartsViewDtoList =
                this.carService.findAllCarsWithParts();

        JAXBContext jaxbContext = JAXBContext.newInstance(CarWithPartsViewDto.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        OutputStream outputStream = new FileOutputStream(CAR_WITH_PARTS_OUTPUT);
        BufferedWriter bfw =
                new BufferedWriter(new OutputStreamWriter(outputStream));

        jaxbMarshaller.marshal(carWithPartsViewDtoList, bfw);
    }

    private void addCustomersWithCarsAndSpentMoneyToFile() throws IOException, JAXBException {
        CustomersCustomerWithCarsAndMoneyDto customersCustomerWithCarsAndMoneyDto =
                this.customerService.findAllCustomersWithCarsAndSpentMoney();

        JAXBContext jaxbContext = JAXBContext.newInstance(CustomersCustomerWithCarsAndMoneyDto.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        OutputStream outputStream = new FileOutputStream(CUSTOMERS_WITH_CARS_MONEY);
        BufferedWriter bfw =
                new BufferedWriter(new OutputStreamWriter(outputStream));

        jaxbMarshaller.marshal(customersCustomerWithCarsAndMoneyDto, bfw);
    }

    private void addSalesToFile() throws IOException, JAXBException {
        SaleViewDto saleViewDto =
                this.saleService.getSales();

        JAXBContext jaxbContext = JAXBContext.newInstance(SaleViewDto.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        OutputStream outputStream = new FileOutputStream(SALES_OUTPUT);
        BufferedWriter bfw =
                new BufferedWriter(new OutputStreamWriter(outputStream));

        jaxbMarshaller.marshal(saleViewDto, bfw);
    }
}
