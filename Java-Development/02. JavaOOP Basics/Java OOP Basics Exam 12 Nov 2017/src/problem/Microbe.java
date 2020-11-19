package problem;

public abstract class Microbe extends Cell {
    private int virulence;
    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    public int getVirulence() {
        return this.virulence;
    }

    @Override
    public int virulence() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int energy() {
        return 0;
    }

    @Override
    public int velocity() {
        return 0;
    }
}
