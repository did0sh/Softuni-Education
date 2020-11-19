package problem;

import java.util.*;
import java.util.stream.Collectors;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private Set<String> allIds;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.setId(id);
        this.setRows(rows);
        this.setCols(cols);
        this.cells = new ArrayList<>();
        this.allIds = new LinkedHashSet<>();
        this.addId();
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setRows(int rows) {
        if (rows >= 0){
            this.rows = rows;
        }
    }

    private void setCols(int cols) {
        if (cols >= 0){
            this.cols = cols;
        }
    }

    public String getId() {
        return this.id;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    private void addId(){
        this.allIds.add(this.getId());
    }

    public List<Cell> getCells() {
        return this.cells;
    }


    public void addCell(Cell cell){
        this.cells.add(cell);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("----Cluster ").append(this.id).append("\r\n");
        Comparator<Cell> byRow = Comparator.comparing(Cell::getPositionRow);
        Comparator<Cell> byCol = Comparator.comparing(Cell::getPositionCol);
        List<Cell> sorted = this.cells.stream().sorted(byRow.thenComparing(byCol)).collect(Collectors.toList());
        for (Cell cell : sorted) {
            sb.append(cell.toString());
        }
        return sb.toString();
    }

}
