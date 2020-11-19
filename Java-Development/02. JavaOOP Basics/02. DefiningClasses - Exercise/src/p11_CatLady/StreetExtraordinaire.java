package p11_CatLady;

public class StreetExtraordinaire extends Cat {
    private double decibleMeow;

    public StreetExtraordinaire(String name, double decibleMeow) {
        super(name, "StreetExtraordinaire");
        this.decibleMeow = decibleMeow;
    }

    public double getDecibleMeow() {
        return this.decibleMeow;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f%n", super.getType(), super.getName(), this.decibleMeow);
    }
}
