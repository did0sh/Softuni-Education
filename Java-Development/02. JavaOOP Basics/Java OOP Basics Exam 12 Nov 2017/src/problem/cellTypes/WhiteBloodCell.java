package problem.cellTypes;

import problem.BloodCell;

public class WhiteBloodCell extends BloodCell {
    private int size;
    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.setSize(size);
    }

    private void setSize(int size) {
        if (size >= 0){
            this.size = size;
        }
    }

    @Override
    public int energy() {
        int energy = 0;
        return energy = (this.getHealth() + this.size()) * 2;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("------Cell ").append(super.getId()).append(String.format(" [%d,%d]", super.getPositionRow(), super.getPositionCol())).append("\r\n");
        sb.append("--------Health: ").append(super.getHealth()).append(" | ");
        sb.append("Size: ").append(this.size).append(" | Energy: ").append(this.energy()).append("\r\n");
        return sb.toString();
    }
}
