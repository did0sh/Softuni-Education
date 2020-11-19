package productshop.service;

import productshop.domain.dtos.seed.xml.CategoriesCategoryDto;
import productshop.domain.dtos.view.xml.CategoryWithProductsCountDto;

public interface CategoryService {

    void seedCategories(CategoriesCategoryDto categorySeedDto);

    CategoryWithProductsCountDto findAllCategories();
}
