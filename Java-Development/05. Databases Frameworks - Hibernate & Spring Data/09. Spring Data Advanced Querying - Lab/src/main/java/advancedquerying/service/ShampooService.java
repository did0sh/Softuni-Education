package advancedquerying.service;

import advancedquerying.domain.entities.Shampoo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShampooService {

    //problem.01
    //List<String> findAllShampoosByGivenSize();

    //problem.02
//    List<String> findAllShampoosByGivenSizeOrLabel();

    //problem.03
//    List<String> findAllShampoosWithPriceHigherThanGivenPrice();

    //problem.06
    // Long countAllShampoosWithPriceLessThanGivenPrice();

    //problem.07
    //List<String> findAllShampoosContainingIngredient();

    //problem.08
    //List<String> findAllShampoosWithCountOfIngredientsLessThan();

    //problem.09
    String findShampooWithIngredientName();
}
