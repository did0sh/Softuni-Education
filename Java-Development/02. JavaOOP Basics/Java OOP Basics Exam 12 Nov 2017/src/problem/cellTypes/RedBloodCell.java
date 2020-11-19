package problem.cellTypes;

import problem.BloodCell;

public class RedBloodCell extends BloodCell {
    private int velocity;
    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.setVelocity(velocity);
    }

    private void setVelocity(int velocity) {
        if (velocity >= 0){
            this.velocity = velocity;
        }
    }

    @Override
    public int energy() {
        int energy = 0;
        return energy = this.getHealth() + this.velocity();
    }

    @Override
    public int velocity() {
        return this.velocity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("------Cell ").append(super.getId()).append(String.format(" [%d,%d]", super.getPositionRow(), super.getPositionCol())).append("\r\n");
        sb.append("--------Health: ").append(super.getHealth()).append(" | ");
        sb.append("Velocity: ").append(this.velocity).append(" | Energy: ").append(this.energy()).append("\r\n");
        return sb.toString();
    }
}
