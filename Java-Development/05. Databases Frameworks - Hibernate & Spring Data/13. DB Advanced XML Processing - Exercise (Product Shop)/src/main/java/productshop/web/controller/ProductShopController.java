package productshop.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import productshop.domain.dtos.seed.xml.CategoriesCategoryDto;
import productshop.domain.dtos.seed.xml.ProductsProductDto;
import productshop.domain.dtos.seed.xml.UsersUserDto;
import productshop.domain.dtos.view.xml.CategoryWithProductsCountDto;
import productshop.domain.dtos.view.xml.ProductsInRangeDto;
import productshop.domain.dtos.view.xml.UserSoldProductsDto;
import productshop.domain.entities.Product;
import productshop.service.CategoryService;
import productshop.service.ProductService;
import productshop.service.UserService;
import productshop.util.FileIOUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductShopController implements CommandLineRunner {
    private final static String USER_FILE_PATH = "/files/users.xml";
    private final static String CATEGORY_FILE_PATH = "/files/categories.xml";
    private final static String PRODUCT_FILE_PATH = "/files/products.xml";

    private final static String PRODUCTS_IN_RANGE_OUTPUT = "C:\\Users\\user\\Downloads\\hw\\13. DB Advanced XML Processing - Exercise (Product Shop)\\src\\main\\resources\\output\\products-in-range.xml";
    private final static String SOLD_PRODUCTS_OUTPUT = "C:\\Users\\user\\Downloads\\hw\\13. DB Advanced XML Processing - Exercise (Product Shop)\\src\\main\\resources\\output\\sold-products.xml";
    private final static String CATEGORIES_OUTPUT = "C:\\Users\\user\\Downloads\\hw\\13. DB Advanced XML Processing - Exercise (Product Shop)\\src\\main\\resources\\output\\categories-with-products.xml";


    private final FileIOUtil fileIOUtil;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public ProductShopController(FileIOUtil fileIOUtil, UserService userService, CategoryService categoryService, ProductService productService) {
        this.fileIOUtil = fileIOUtil;
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        //this.seedUsers();

        //this.seedCategories();

        //this.seedProducts();

        //Query 1
        //this.productsInRange();

        //Query 2
        //this.successfullySoldProducts();

        //Query 3
        this.categoriesByProductsCount();
    }

    private void seedUsers() throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(UsersUserDto.class);

        InputStream inputStream = getClass().getResourceAsStream(USER_FILE_PATH);
        BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));

        Unmarshaller unmarshaller = context.createUnmarshaller();
        UsersUserDto userSeedDtos = (UsersUserDto) unmarshaller.unmarshal(bfr);

        this.userService.seedUsers(userSeedDtos);
    }

    private void seedCategories() throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(CategoriesCategoryDto.class);

        InputStream inputStream = getClass().getResourceAsStream(CATEGORY_FILE_PATH);
        BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));

        Unmarshaller unmarshaller = context.createUnmarshaller();
        CategoriesCategoryDto categoriesCategoryDto = (CategoriesCategoryDto) unmarshaller.unmarshal(bfr);

        this.categoryService.seedCategories(categoriesCategoryDto);
    }

    private void seedProducts() throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(ProductsProductDto.class);

        InputStream inputStream = getClass().getResourceAsStream(PRODUCT_FILE_PATH);
        BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));

        Unmarshaller unmarshaller = context.createUnmarshaller();
        ProductsProductDto productsProductDto = (ProductsProductDto) unmarshaller.unmarshal(bfr);

        this.productService.seedProducts(productsProductDto);
    }


    //Query 1
    private void productsInRange() throws IOException, JAXBException {
        ProductsInRangeDto productInRangeDtos = this.productService.productInRange(BigDecimal.valueOf(500),
                BigDecimal.valueOf(1000));

        JAXBContext jaxbContext = JAXBContext.newInstance(ProductsInRangeDto.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        OutputStream outputStream = new FileOutputStream(PRODUCTS_IN_RANGE_OUTPUT);
        BufferedWriter bfw =
                new BufferedWriter(new OutputStreamWriter(outputStream));

        jaxbMarshaller.marshal(productInRangeDtos, bfw);

    }

//    //Query 2
    private void successfullySoldProducts() throws IOException, JAXBException {
        UserSoldProductsDto userSoldProductsDtos = this.userService.getAllUsersWithMoreThanOneSoldProduct();

        JAXBContext jaxbContext = JAXBContext.newInstance(UserSoldProductsDto.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        OutputStream outputStream = new FileOutputStream(SOLD_PRODUCTS_OUTPUT);
        BufferedWriter bfw =
                new BufferedWriter(new OutputStreamWriter(outputStream));

        jaxbMarshaller.marshal(userSoldProductsDtos, bfw);
    }

//    //Query 3
    private void categoriesByProductsCount() throws IOException, JAXBException {
        CategoryWithProductsCountDto categoryWithProductsCountDtos =
                this.categoryService.findAllCategories();

        JAXBContext jaxbContext = JAXBContext.newInstance(CategoryWithProductsCountDto.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        OutputStream outputStream = new FileOutputStream(CATEGORIES_OUTPUT);
        BufferedWriter bfw =
                new BufferedWriter(new OutputStreamWriter(outputStream));

        jaxbMarshaller.marshal(categoryWithProductsCountDtos, bfw);
    }
}
