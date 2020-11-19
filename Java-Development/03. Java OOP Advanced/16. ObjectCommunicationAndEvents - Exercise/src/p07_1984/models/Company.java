package p07_1984.models;

public class Company extends Entity {
    private int turnover;
    private int revenue;

    public Company(String id, String name, int turnover, int revenue) {
        super(id, name);
        this.turnover = turnover;
        this.revenue = revenue;
    }
}
