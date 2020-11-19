package p03_WildFarm;

public abstract class Mammal extends Animal {
    private String livingRegion;
    public Mammal(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight);
        this.livingRegion = livingRegion;
    }

    protected String getLivingRegion() {
        return this.livingRegion;
    }
}
