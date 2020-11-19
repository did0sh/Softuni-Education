package problem.microbeTypes;

import problem.Microbe;

public class Fungi extends Microbe {
    public Fungi(String id, int health, int positionRow, int positionCol, int virulence){
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int virulence() {
        return super.getVirulence();
    }

    @Override
    public int energy() {
        int energy = 0;
        return energy = (this.getHealth() + this.virulence()) / 4;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("------Cell ").append(super.getId()).append(String.format(" [%d,%d]", super.getPositionRow(), super.getPositionCol())).append("\r\n");
        sb.append("--------Health: ").append(super.getHealth()).append(" | ").append("Virulence: ").append(super.getVirulence()).append(" | Energy: ");
        sb.append(this.energy()).append("\r\n");
        return sb.toString();
    }
}
