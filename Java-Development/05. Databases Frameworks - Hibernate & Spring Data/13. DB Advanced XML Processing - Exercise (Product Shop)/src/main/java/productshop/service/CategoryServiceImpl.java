package productshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productshop.domain.dtos.seed.CategorySeedDto;
import productshop.domain.dtos.seed.xml.CategoriesCategoryDto;
import productshop.domain.dtos.view.CategoryNameDto;
import productshop.domain.dtos.view.xml.CategoryWithProductsCountDto;
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
    public void seedCategories(CategoriesCategoryDto categorySeedDto) {
        for (CategorySeedDto categoryDto: categorySeedDto.getCategorySeedDtos()) {
            if (!this.validatorUtil.isValid(categoryDto)){
                this.validatorUtil.violations(categoryDto)
                        .forEach(violation -> System.out.println(violation.getMessage()));

                continue;
            }

            Category entity = this.modelMapper.map(categoryDto, Category.class);

            this.categoryRepository.saveAndFlush(entity);
        }
    }

//    //Query 3
    @Override
    public CategoryWithProductsCountDto findAllCategories() {
        List<Category> categories = this.categoryRepository.getAll();

        CategoryWithProductsCountDto categoryWithProductsCountDtoList
                = new CategoryWithProductsCountDto();

        List<CategoryNameDto> categoryNameDtos = new ArrayList<>();

        for (Category category : categories) {
            CategoryNameDto categoryNameDto =
                            this.modelMapper.map(category, CategoryNameDto.class);

            categoryNameDto.setProductsCount(category.getProducts().size());

            BigDecimal totalRevenue = category.getProducts()
                    .stream()
                    .map(Product::getPrice)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO);

            categoryNameDto.setTotalRevenue(totalRevenue);

            if (totalRevenue.doubleValue() != 0 && categoryNameDto.getProductsCount() != 0){
                categoryNameDto.setAveragePrice(totalRevenue.doubleValue() / categoryNameDto.getProductsCount());
            }

            categoryNameDtos.add(categoryNameDto);
        }

        categoryWithProductsCountDtoList.setCategoryNameDtos(categoryNameDtos);

        return categoryWithProductsCountDtoList;
    }
}
