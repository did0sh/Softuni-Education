package productshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productshop.domain.dtos.CategorySeedDto;
import productshop.domain.dtos.CategoryWithProductsCountDto;
import productshop.domain.entities.Category;
import productshop.domain.entities.Product;
import productshop.repository.CategoryRepository;
import productshop.util.ValidatorUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCategories(CategorySeedDto[] categorySeedDtos) {
        for (CategorySeedDto categorySeedDto : categorySeedDtos) {
            if (!this.validatorUtil.isValid(categorySeedDto)){
                this.validatorUtil.violations(categorySeedDto)
                        .forEach(violation -> System.out.println(violation.getMessage()));

                continue;
            }

            Category entity = this.modelMapper.map(categorySeedDto, Category.class);

            this.categoryRepository.saveAndFlush(entity);
        }
    }

    //Query 3
    @Override
    public List<CategoryWithProductsCountDto> findAllCategories() {
        List<Category> categories = this.categoryRepository.getAll();

        List<CategoryWithProductsCountDto> categoryWithProductsCountDtoList = new ArrayList<>();

        for (Category category : categories) {
            CategoryWithProductsCountDto categoryWithProductsCountDto =
                            this.modelMapper.map(category, CategoryWithProductsCountDto.class);

            categoryWithProductsCountDto.setProductsCount(category.getProducts().size());

            BigDecimal totalRevenue = category.getProducts()
                    .stream()
                    .map(Product::getPrice)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO);

            categoryWithProductsCountDto.setTotalRevenue(totalRevenue);

            if (totalRevenue.doubleValue() != 0 && categoryWithProductsCountDto.getProductsCount() != 0){
                categoryWithProductsCountDto.setAveragePrice(totalRevenue.doubleValue() / categoryWithProductsCountDto.getProductsCount());
            }

            categoryWithProductsCountDtoList.add(categoryWithProductsCountDto);
        }

        return categoryWithProductsCountDtoList;
    }
}
