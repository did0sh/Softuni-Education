package productshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productshop.domain.dtos.seed.ProductSeedDto;
import productshop.domain.dtos.seed.xml.ProductsProductDto;
import productshop.domain.dtos.view.ProductNamePriceSellerDto;
import productshop.domain.dtos.view.xml.ProductsInRangeDto;
import productshop.domain.entities.Category;
import productshop.domain.entities.Product;
import productshop.domain.entities.User;
import productshop.repository.CategoryRepository;
import productshop.repository.ProductRepository;
import productshop.repository.UserRepository;
import productshop.util.ValidatorUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository,
                              UserRepository userRepository,
                              ValidatorUtil validatorUtil,
                              ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedProducts(ProductsProductDto productSeedDto) {
        for (ProductSeedDto productDto : productSeedDto.getProductSeedDtos()) {
            if (!this.validatorUtil.isValid(productDto)) {
                this.validatorUtil.violations(productDto)
                        .forEach(violation -> System.out.println(violation.getMessage()));

                continue;
            }

            Product entity = this.modelMapper.map(productDto, Product.class);
            entity.setSeller(this.getRandomUser());

            Random random = new Random();

            if (random.nextInt() % 13 != 0) {
                entity.setBuyer(this.getRandomUser());
            }

            entity.setCategories(this.getRandomCategories());

            this.productRepository.saveAndFlush(entity);
        }
    }

    //Query 1
    @Override
    public ProductsInRangeDto productInRange(BigDecimal low, BigDecimal high) {
        List<Product> products = this.productRepository.findAllByPriceBetweenAndBuyerOrderByPrice(low, high, null);

        List<ProductNamePriceSellerDto> productNamePriceSellerDtos = new ArrayList<>();

        for (Product product : products) {
            ProductNamePriceSellerDto productNamePriceSellerDto = this.modelMapper.map(product, ProductNamePriceSellerDto.class);
            productNamePriceSellerDto.setSeller(String.format("%s %s",
                    product.getSeller().getFirstName(),
                    product.getSeller().getLastName()));

            productNamePriceSellerDtos.add(productNamePriceSellerDto);
        }

        ProductsInRangeDto productInRangeDtos = new ProductsInRangeDto();
        productInRangeDtos.setProductNamePriceSellerDtos(productNamePriceSellerDtos);

        return productInRangeDtos;
    }

    private User getRandomUser(){
        Random random = new Random();

        return this.userRepository
                .getOne(random.nextInt((int)this.userRepository.count() - 1) + 1);
    }

    private List<Category> getRandomCategories(){
        Random random = new Random();

        List<Category> categories = new ArrayList<>();

        int categoriesBound = random.nextInt((int)this.categoryRepository.count() - 1) + 1;

        for (int i = 0; i < categoriesBound ; i++) {
            categories.add(this.categoryRepository.getOne(random.nextInt((int)this.categoryRepository.count() - 1) + 1));
        }

        return categories;
    }
}
