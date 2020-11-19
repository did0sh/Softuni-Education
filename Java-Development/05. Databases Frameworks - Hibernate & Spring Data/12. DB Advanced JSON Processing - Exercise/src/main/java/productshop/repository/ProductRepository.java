package productshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import productshop.domain.entities.Product;
import productshop.domain.entities.User;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    //Query 1
    List<Product> findAllByPriceBetweenAndBuyerOrderByPrice(BigDecimal low, BigDecimal high, User buyer);

}
