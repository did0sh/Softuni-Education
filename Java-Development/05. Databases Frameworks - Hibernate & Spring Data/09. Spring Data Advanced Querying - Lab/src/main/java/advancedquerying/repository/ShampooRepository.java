package advancedquerying.repository;

import advancedquerying.domain.entities.Ingredient;
import advancedquerying.domain.entities.Shampoo;
import advancedquerying.domain.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    //problem.01
    List<Shampoo> findAllBySizeOrderById (Size size);

    //problem.02
    List<Shampoo> findAllBySizeOrLabelIdOrderByPrice(Size size, Long id);

    //problem.03
    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    //problem.06
    Long countAllByPriceLessThan(BigDecimal price);

    //problem.07
//    @Query("SELECT s " +
//            "FROM advancedquerying.domain.entities.Shampoo AS s " +
//            "JOIN s.ingredients AS i " +
//            "WHERE i.name IN :ingredients")
//    List<Shampoo> findByHavingIngredients(@Param("ingredients") List<String> ingredients);

    //problem.08
//    @Query("SELECT s " +
//            "FROM advancedquerying.domain.entities.Shampoo AS s " +
//            "WHERE s.ingredients.size < :count")
//    List<Shampoo> findAllByIngredientsCountLess(@Param("count") int count);

    //problem.09
    @Query("SELECT sum(i.price) " +
            "FROM advancedquerying.domain.entities.Shampoo AS s " +
            "JOIN s.ingredients AS i " +
            "WHERE s.brand = :brand")
    BigDecimal getTotalIngredientsPrice(@Param("brand") String brand);

}
