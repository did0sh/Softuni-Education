package advancedquerying.service;

import advancedquerying.domain.entities.Ingredient;
import advancedquerying.domain.entities.Shampoo;
import advancedquerying.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    //problem.04
//    @Override
//    public List<String> findIngredientsWhereNameStartsWith() {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//
//        List<Ingredient> ingredients = this.ingredientRepository.findAllByNameIsStartingWith(input);
//        return ingredients.stream()
//                .map(ingredient -> String.format("%s", ingredient.getName()))
//                .collect(Collectors.toList());
//    }

    //problem.05
//    @Override
//    public List<String> findIngredientsNames() {
//        Scanner scanner = new Scanner(System.in);
//        List<String> names = new ArrayList<>();
//
//        String input;
//        while (true){
//            input = scanner.nextLine();
//            if (input.equals("")){
//                break;
//            }
//            names.add(input);
//        }
//
//        List<Ingredient> ingredients = this.ingredientRepository.findIngredientsByNameInOrderByPrice(names);
//        return ingredients.stream()
//                .map(ingredient -> String.format("%s", ingredient.getName()))
//                .collect(Collectors.toList());
//    }
}
