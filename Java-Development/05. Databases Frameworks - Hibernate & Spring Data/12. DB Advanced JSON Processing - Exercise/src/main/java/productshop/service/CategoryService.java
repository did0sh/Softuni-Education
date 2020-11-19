package productshop.service;

import productshop.domain.dtos.CategorySeedDto;
import productshop.domain.dtos.CategoryWithProductsCountDto;

import java.util.List;

public interface CategoryService {

    void seedCategories(CategorySeedDto[] categorySeedDtos);

    List<CategoryWithProductsCountDto> findAllCategories();
}
