package productshop.service;

import productshop.domain.dtos.seed.xml.ProductsProductDto;
import productshop.domain.dtos.view.xml.ProductsInRangeDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void seedProducts(ProductsProductDto productsProductDto);

//    //Query 1
    ProductsInRangeDto productInRange(BigDecimal low, BigDecimal high);
}
