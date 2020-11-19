package advancedquerying.repository;

import advancedquerying.domain.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    //problem.04
    //List<Ingredient> findAllByNameIsStartingWith(String letter);

    //problem.05
    //List<Ingredient> findIngredientsByNameInOrderByPrice(List<String> name);

}
