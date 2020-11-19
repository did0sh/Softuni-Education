package problem;

public abstract class Cell {
    private String id;
    private int health;
    private int positionRow;
    private int positionCol;
    private Object[][] matrix;

    public Cell(String id, int health, int positionRow, int positionCol) {
        this.setId(id);
        this.setHealth(health);
        this.setPositionRow(positionRow);
        this.setPositionCol(positionCol);
    }

    private void setId(String id) {
        this.id = id;
    }

    public void setHealth(int health) {
            this.health = health;
    }

    public void setPositionRow(int positionRow) {
            this.positionRow = positionRow;
    }

    public void setPositionCol(int positionCol) {
            this.positionCol = positionCol;
    }

    public String getId() {
        return this.id;
    }

    public int getHealth() {
        return this.health;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }



    abstract int size();

    abstract int energy();

    abstract int velocity();

    abstract int virulence();

    @Override
    public String toString() {
        return super.toString();
    }
}
