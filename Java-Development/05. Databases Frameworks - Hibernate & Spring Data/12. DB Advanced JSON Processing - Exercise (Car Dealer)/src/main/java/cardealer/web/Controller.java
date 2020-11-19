package cardealer.web;

import cardealer.domain.dto.*;
import cardealer.service.*;
import cardealer.util.FileIOUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller implements CommandLineRunner {
    private static final String SUPPLIER_FILE_PATH =
            "C:\\Users\\user\\IdeaProjects\\06. Databases Frameworks - Hibernate & Spring Data\\12. DB Advanced JSON Processing - Exercise (Car Dealer)\\src\\main\\resources\\files\\suppliers.json";

    private static final String PART_FILE_PATH =
            "C:\\Users\\user\\IdeaProjects\\06. Databases Frameworks - Hibernate & Spring Data\\12. DB Advanced JSON Processing - Exercise (Car Dealer)\\src\\main\\resources\\files\\parts.json";


    private static final String CAR_FILE_PATH =
            "C:\\Users\\user\\IdeaProjects\\06. Databases Frameworks - Hibernate & Spring Data\\12. DB Advanced JSON Processing - Exercise (Car Dealer)\\src\\main\\resources\\files\\cars.json";


    private static final String CUSTOMER_FILE_PATH =
            "C:\\Users\\user\\IdeaProjects\\06. Databases Frameworks - Hibernate & Spring Data\\12. DB Advanced JSON Processing - Exercise (Car Dealer)\\src\\main\\resources\\files\\customers.json";

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final Gson gson;
    private final FileIOUtil fileIOUtil;

    @Autowired
    public Controller(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService, Gson gson, FileIOUtil fileIOUtil) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.gson = gson;
        this.fileIOUtil = fileIOUtil;
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
        this.addCarsWithPartsToFile();
    }

    private void seedSuppliers() throws IOException {
        String supplierFileContent = this.fileIOUtil.readFile(SUPPLIER_FILE_PATH);

        SupplierSeedDto[] supplierSeedDtos = this.gson.fromJson(supplierFileContent, SupplierSeedDto[].class);

        this.supplierService.seedSuppliers(supplierSeedDtos);
    }

    private void seedParts() throws IOException {
        String partFileContent = this.fileIOUtil.readFile(PART_FILE_PATH);

        PartsSeedDto[] partsSeedDtos = this.gson.fromJson(partFileContent, PartsSeedDto[].class);

        this.partService.seedParts(partsSeedDtos);
    }

    private void seedCars() throws IOException {
        String carFileContent = this.fileIOUtil.readFile(CAR_FILE_PATH);

        CarSeedDto[] carSeedDtos = this.gson.fromJson(carFileContent, CarSeedDto[].class);

        this.carService.seedCars(carSeedDtos);
    }

    private void seedCustomers() throws IOException {
        String customerFileContent = this.fileIOUtil.readFile(CUSTOMER_FILE_PATH);

        CustomerSeedDto[] customerSeedDtos = this.gson.fromJson(customerFileContent, CustomerSeedDto[].class);

        this.customerService.seedCustomers(customerSeedDtos);
    }

    private void seedSales() throws IOException {

        this.saleService.seedSales();
    }

    private void addCustomersToFile() throws IOException {
        List<CustomerOrderedByBirthDateView> customerOrderedByBirthDateViewList
                = this.customerService.findAllCustomersOrderedByBirthDate();

        String customerJson = this.gson.toJson(customerOrderedByBirthDateViewList);

        String filePath = "C:\\Users\\user\\IdeaProjects\\06. Databases Frameworks - Hibernate & Spring Data\\12. DB Advanced JSON Processing - Exercise (Car Dealer)\\src\\main\\resources\\output\\customers-orderedby-birthdate.json";
        File file = new File(filePath);

        FileWriter writer = new FileWriter(file);
        writer.write(customerJson);
        writer.close();
    }

    private void addToyotaCarsToFile() throws IOException {
        List<CarToyotaView> carToyotaViewList = this.carService.findAllCarsFromToyota();

        String carToyotaToJson = this.gson.toJson(carToyotaViewList);

        String filePath = "C:\\Users\\user\\IdeaProjects\\06. Databases Frameworks - Hibernate & Spring Data\\12. DB Advanced JSON Processing - Exercise (Car Dealer)\\src\\main\\resources\\output\\toyota-cars.json";
        File file = new File(filePath);

        FileWriter writer = new FileWriter(file);
        writer.write(carToyotaToJson);
        writer.close();
    }

    private void addSuppliersToFile() throws IOException {
        List<LocalSupplierDto> localSupplierDtoList =
                this.supplierService.findAllLocalSuppliers();

        String supplierToJson = this.gson.toJson(localSupplierDtoList);

        String filePath = "C:\\Users\\user\\IdeaProjects\\06. Databases Frameworks - Hibernate & Spring Data\\12. DB Advanced JSON Processing - Exercise (Car Dealer)\\src\\main\\resources\\output\\local-suppliers.json";
        File file = new File(filePath);

        FileWriter writer = new FileWriter(file);
        writer.write(supplierToJson);
        writer.close();
    }

    private void addCarsWithPartsToFile() throws IOException {
        List<CarWithPartsViewDto> carWithPartsViewDtoList =
                this.carService.findAllCarsWithParts();

        String carToJson = this.gson.toJson(carWithPartsViewDtoList);

        String filePath = "C:\\Users\\user\\IdeaProjects\\06. Databases Frameworks - Hibernate & Spring Data\\12. DB Advanced JSON Processing - Exercise (Car Dealer)\\src\\main\\resources\\output\\car-with-parts.json";
        File file = new File(filePath);

        FileWriter writer = new FileWriter(file);
        writer.write(carToJson);
        writer.close();
    }
}
