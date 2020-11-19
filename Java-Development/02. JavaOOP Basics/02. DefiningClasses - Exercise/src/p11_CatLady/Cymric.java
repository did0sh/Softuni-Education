package p11_CatLady;

public class Cymric extends Cat {
    private double furLength;

    public Cymric(String name, double furLength) {
        super(name, "Cymric");
        this.furLength = furLength;
    }

    public double getFurLength() {
        return this.furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f%n", super.getType(), super.getName(), this.furLength);
    }
}
