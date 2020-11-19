package p03_CoffeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private List<Integer> coins;
    private List<Coffee> soldCoffees;

    public CoffeeMachine() {
        this.coins = new ArrayList<>();
        this.soldCoffees = new ArrayList<>();
    }

    public void buyCoffee(String size, String type){
        Coffee coffee = new Coffee(size, type);
        int coinsInMachine = this.coins.stream().reduce((x,y) -> x+y).get();

        if (coffee.getSize().getPrice() <= coinsInMachine){
            this.soldCoffees.add(coffee);
            this.coins.clear();
        }
    }

    public void insertCoin(String coin){
        int coinValue = Enum.valueOf(Coin.class, coin).getValue();
        this.coins.add(coinValue);
    }

    public Iterable<Coffee> coffeesSold(){
        return this.soldCoffees;
    }

}
