package p04_ShoppingSpree;

public class Product {
    private String name;
    private int cost;

    public Product(String name, int cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {
        if (name.length() < 1 || name.equals(" ")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setCost(int cost) {
        if (cost < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }

    public int getCost() {
        return this.cost;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
