package advancedquerying.controller;

import advancedquerying.service.IngredientServiceImpl;
import advancedquerying.service.ShampooServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class AppController implements CommandLineRunner {

    private final ShampooServiceImpl shampooService;
    private final IngredientServiceImpl ingredientService;

    @Autowired
    public AppController(ShampooServiceImpl shampooService, IngredientServiceImpl ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {

//        problem.01
//        this.shampooService.findAllShampoosByGivenSize()
//            .forEach(System.out::println);

      //problem.02
//      this.shampooService.findAllShampoosByGivenSizeOrLabel()
//            .forEach(System.out::println);

        //problem.03
//      this.shampooService.findAllShampoosWithPriceHigherThanGivenPrice()
//            .forEach(System.out::println);

        //problem.04
//      this.ingredientService.findIngredientsWhereNameStartsWith()
//            .forEach(System.out::println);

        //problem.05
//      this.ingredientService.findIngredientsNames()
//            .forEach(System.out::println);

        //problem.06
        //System.out.println(this.shampooService.countAllShampoosWithPriceLessThanGivenPrice());

        //problem.07
//      this.shampooService.findAllShampoosContainingIngredient()
//            .forEach(System.out::println);

        //problem.08
//        this.shampooService.findAllShampoosWithCountOfIngredientsLessThan()
//                .forEach(System.out::println);

        //problem.09
        System.out.println(this.shampooService.findShampooWithIngredientName());
    }
}
