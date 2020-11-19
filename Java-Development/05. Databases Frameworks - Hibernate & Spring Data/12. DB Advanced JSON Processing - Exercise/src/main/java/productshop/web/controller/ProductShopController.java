package productshop.web.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import productshop.domain.dtos.*;
import productshop.service.CategoryService;
import productshop.service.ProductService;
import productshop.service.UserService;
import productshop.util.FileIOUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductShopController implements CommandLineRunner {
    private final static String USER_FILE_PATH = "C:\\Users\\user\\IdeaProjects\\06. Databases Frameworks - Hibernate & Spring Data\\12. DB Advanced JSON Processing - Exercise\\src\\main\\resources\\files\\users.json";
    private final static String CATEGORY_FILE_PATH = "C:\\Users\\user\\IdeaProjects\\06. Databases Frameworks - Hibernate & Spring Data\\12. DB Advanced JSON Processing - Exercise\\src\\main\\resources\\files\\categories.json";
    private final static String PRODUCT_FILE_PATH = "C:\\Users\\user\\IdeaProjects\\06. Databases Frameworks - Hibernate & Spring Data\\12. DB Advanced JSON Processing - Exercise\\src\\main\\resources\\files\\products.json";

    private final FileIOUtil fileIOUtil;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final Gson gson;

    @Autowired
    public ProductShopController(FileIOUtil fileIOUtil, UserService userService, Gson gson, CategoryService categoryService, ProductService productService) {
        this.fileIOUtil = fileIOUtil;
        this.userService = userService;
        this.gson = gson;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
//        this.seedUsers();
//
//        this.seedCategories();
//
//        this.seedProducts();

        //Query 1
        //this.productsInRange();

        //Query 2
        //this.successfullySoldProducts();

        //Query 3
        this.categoriesByProductsCount();
    }

    private void seedUsers() throws IOException {
        String userFileContent = this.fileIOUtil.readFile(USER_FILE_PATH);

        UserSeedDto[] userSeedDtos = this.gson.fromJson(userFileContent, UserSeedDto[].class);

        this.userService.seedUsers(userSeedDtos);
    }

    private void seedCategories() throws IOException {
        String categoriesFileContent = this.fileIOUtil.readFile(CATEGORY_FILE_PATH);

        CategorySeedDto[] categorySeedDtos = this.gson.fromJson(categoriesFileContent, CategorySeedDto[].class);

        this.categoryService.seedCategories(categorySeedDtos);
    }

    private void seedProducts() throws IOException {
        String productsFileContent = this.fileIOUtil.readFile(PRODUCT_FILE_PATH);

        ProductSeedDto[] productSeedDtos = this.gson.fromJson(productsFileContent, ProductSeedDto[].class);

        this.productService.seedProducts(productSeedDtos);
    }


    //Query 1
    private void productsInRange() throws IOException {
        List<ProductInRangeDto> productInRangeDtos = this.productService.productInRange(BigDecimal.valueOf(500),
                BigDecimal.valueOf(1000));

        String productsInRangeJson = this.gson.toJson(productInRangeDtos);

        String filePath = "C:\\Users\\user\\IdeaProjects\\06. Databases Frameworks - Hibernate & Spring Data\\12. DB Advanced JSON Processing - Exercise\\src\\main\\resources\\output\\products-in-range.json";
        File file = new File(filePath);

        FileWriter writer = new FileWriter(file);
        writer.write(productsInRangeJson);
        writer.close();
    }

    //Query 2
    private void successfullySoldProducts() throws IOException {
        List<UserSoldProductsDto> userSoldProductsDtos = this.userService.getAllUsersWithMoreThanOneSoldProduct();

        String soldProductsJson = this.gson.toJson(userSoldProductsDtos);

        String filePath = "C:\\Users\\user\\IdeaProjects\\06. Databases Frameworks - Hibernate & Spring Data\\12. DB Advanced JSON Processing - Exercise\\src\\main\\resources\\output\\successfully-sold-products.json";
        File file = new File(filePath);

        FileWriter writer = new FileWriter(file);
        writer.write(soldProductsJson);
        writer.close();
    }

    //Query 3
    private void categoriesByProductsCount() throws IOException {
        List<CategoryWithProductsCountDto> categoryWithProductsCountDtos =
                this.categoryService.findAllCategories();

        String categoriesJson = this.gson.toJson(categoryWithProductsCountDtos);

        String filePath = "C:\\Users\\user\\IdeaProjects\\06. Databases Frameworks - Hibernate & Spring Data\\12. DB Advanced JSON Processing - Exercise\\src\\main\\resources\\output\\categories-by-products-count.json";
        File file = new File(filePath);

        FileWriter writer = new FileWriter(file);
        writer.write(categoriesJson);
        writer.close();
    }
}
