package p03_CoffeMachine;

public class Coffee {
    private CoffeeSize size;
    private CoffeeType type;

    public Coffee(String size, String type) {
        this.size = Enum.valueOf(CoffeeSize.class, size.toUpperCase());
        this.type = Enum.valueOf(CoffeeType.class, type.toUpperCase());
    }

    public CoffeeSize getSize() {
        return this.size;
    }

    public CoffeeType getType() {
        return this.type;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append(String.format("%s %s", this.getSize(), this.getType()));
       return sb.toString();
    }
}
