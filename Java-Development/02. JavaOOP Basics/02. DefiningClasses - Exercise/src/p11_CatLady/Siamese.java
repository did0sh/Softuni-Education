package p11_CatLady;

public class Siamese extends Cat {
    private double earSize;

    public Siamese(String name, double earSize) {
        super(name, "Siamese");
        this.earSize = earSize;
    }

    public double getEarSize() {
        return this.earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f%n", super.getType(), super.getName(), this.earSize);
    }
}
