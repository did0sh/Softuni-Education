package p03_WildFarm;

public abstract class Food {
    private Integer quantity;

    public Food(Integer quantity) {
        this.quantity = quantity;
    }

    protected int getQuantity() {
        return this.quantity;
    }

}
