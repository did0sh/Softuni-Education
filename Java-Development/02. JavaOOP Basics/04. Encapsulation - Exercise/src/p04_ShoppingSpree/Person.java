package p04_ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private int money;
    private List<Product> bagOfProducts;

    public Person(String name, int money) {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(int money) {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    private void addProduct(Product product){
        this.bagOfProducts.add(product);
    }

    public int getMoney() {
        return this.money;
    }

    public List<Product> getBagOfProducts() {
        return Collections.unmodifiableList(this.bagOfProducts);
    }

    public void updateMoney(int productCost){
        this.setMoney(this.getMoney() - productCost);
    }

    private String getName() {
        return this.name;
    }

    public void tryPurchase(Product product){
        if (this.getMoney() >= product.getCost()){
            this.setMoney(this.getMoney() - product.getCost());
            this.addProduct(product);
            System.out.printf("%s bought %s%n", this.getName(), product.getName());
        } else {
            throw new IllegalStateException(String.format("%s can't afford %s%n", this.getName(), product.getName()));
        }
    }

    @Override
    public String toString() {
        if (this.getBagOfProducts().size() == 0){
            return this.getName() + " - Nothing bought";
        }
        List<String> products = this.getBagOfProducts().stream().map(Object::toString).collect(Collectors.toList());
        return this.getName() + " - " + String.join(", ", products);
    }
}
