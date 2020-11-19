package advancedquerying.service;

import advancedquerying.domain.entities.Ingredient;
import advancedquerying.domain.entities.Shampoo;
import advancedquerying.repository.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }


    //problem.01
//    @Override
//    public List<String> findAllShampoosByGivenSize() {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine().toUpperCase();
//        Size currentSize = Size.valueOf(input);
//
//        List<Shampoo> shampoos = this.shampooRepository.findAllBySizeOrderById(currentSize);
//        return shampoos.stream()
//                .map(shampoo -> String.format("%s %s %.2flv.",
//                        shampoo.getBrand(),
//                        shampoo.getSize(),
//                        shampoo.getPrice()))
//                .collect(Collectors.toList());
//    }


    //problem.02
//    @Override
//    public List<String> findAllShampoosByGivenSizeOrLabel() {
//        Scanner scanner = new Scanner(System.in);
//        String inputSize = scanner.nextLine().toUpperCase();
//
//        Long labelId = Long.parseLong(scanner.nextLine());
//        Size currentSize = Size.valueOf(inputSize);
//
//        List<Shampoo> shampoos = this.shampooRepository.findAllBySizeOrLabelIdOrderByPrice(currentSize, labelId);
//        return shampoos.stream()
//                .map(shampoo -> String.format("%s %s %.2flv.",
//                        shampoo.getBrand(),
//                        shampoo.getSize(),
//                        shampoo.getPrice()))
//                .collect(Collectors.toList());
//    }

    //problem.03
//    @Override
//    public List<String> findAllShampoosWithPriceHigherThanGivenPrice() {
//        Scanner scanner = new Scanner(System.in);
//        BigDecimal price = new BigDecimal(scanner.nextLine());
//
//        List<Shampoo> shampoos = this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);
//        return shampoos.stream()
//                .map(shampoo -> String.format("%s %s %.2flv.",
//                        shampoo.getBrand(),
//                        shampoo.getSize(),
//                        shampoo.getPrice()))
//                .collect(Collectors.toList());
//    }

    //problem.06
//    @Override
//    public Long countAllShampoosWithPriceLessThanGivenPrice() {
//        Scanner scanner = new Scanner(System.in);
//        BigDecimal price = new BigDecimal(scanner.nextLine());
//
//        return this.shampooRepository.countAllByPriceLessThan(price);
//
//    }

    //problem.07
//    @Override
//    public List<String> findAllShampoosContainingIngredient() {
//        Scanner scanner = new Scanner(System.in);
//        String input;
//        List<String> ingredients = new ArrayList<>();
//
//        while (true){
//            input = scanner.nextLine();
//            if (input.equals("")){
//                break;
//            }
//
//            ingredients.add(input);
//        }
//
//
//        List<Shampoo> shampoos = this.shampooRepository.findByHavingIngredients(ingredients);
//        return shampoos.stream()
//                .map(shampoo -> String.format("%s", shampoo.getBrand()))
//                .collect(Collectors.toList());
//    }

    //problem.08
//    @Override
//    public List<String> findAllShampoosWithCountOfIngredientsLessThan() {
//        Scanner scanner = new Scanner(System.in);
//        int countIngredients = Integer.parseInt(scanner.nextLine());
//
//        List<Shampoo> shampoos = this.shampooRepository.findAllByIngredientsCountLess(countIngredients);
//
//        return shampoos.stream()
//               .map(shampoo -> String.format("%s", shampoo.getBrand()))
//               .collect(Collectors.toList());
//    }

    //problem.09
    @Override
    public String findShampooWithIngredientName() {
        Scanner scanner = new Scanner(System.in);
        String ingredientName = scanner.nextLine();

        BigDecimal ingredientsPrice = this.shampooRepository.getTotalIngredientsPrice(ingredientName);

        return String.format("%.2f", ingredientsPrice);
    }

}
