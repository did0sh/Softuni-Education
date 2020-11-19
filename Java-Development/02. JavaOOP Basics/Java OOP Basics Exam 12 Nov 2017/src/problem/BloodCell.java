package problem;

public abstract class BloodCell extends Cell {
    public BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
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
    int virulence() {
        return 0;
    }

    @Override
    public int velocity() {
        return 0;
    }
}
