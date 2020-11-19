package p02_KingsGambit;

public abstract class AbstractModel implements Identifiable {
    private String name;

    AbstractModel(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
