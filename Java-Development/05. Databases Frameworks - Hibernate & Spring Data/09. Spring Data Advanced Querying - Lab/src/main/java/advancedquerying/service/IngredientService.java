package advancedquerying.service;

import advancedquerying.domain.entities.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IngredientService {

    //problem.04
    //List<String> findIngredientsWhereNameStartsWith();

    //problem.05
    //List<String> findIngredientsNames();

}
