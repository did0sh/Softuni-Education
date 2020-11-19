package problem;

import problem.cellTypes.RedBloodCell;
import problem.cellTypes.WhiteBloodCell;
import problem.microbeTypes.Bacteria;
import problem.microbeTypes.Fungi;
import problem.microbeTypes.Virus;

import java.util.*;
import java.util.stream.Collectors;

public class HealthManager {
    private Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms = new LinkedHashMap<>();
    }

    public String checkCondition(String organismName) {
        StringBuilder sb = new StringBuilder();
        if (this.organisms.containsKey(organismName)) {
            return this.organisms.get(organismName).toString();
        }

        return null;
    }


    public String createOrganism(String name) {
        if (!this.organisms.containsKey(name)) {
            Organism organism = new Organism(name);
            this.organisms.put(name, organism);
            return String.format("Created organism %s%n", name);
        }

        return String.format("Organism %s already exists%n", name);

    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        Cluster cluster = new Cluster(id, rows, cols);

        if (this.organisms.containsKey(organismName)) {
            List<Map.Entry<String, Cluster>> filtered = this.organisms.get(organismName).getClusters()
                    .entrySet().stream().filter(cluster1 -> cluster1.getValue().getId().equals(id)).collect(Collectors.toList());

            if (filtered.size() == 0) {
                this.organisms.get(organismName).getClusters().putIfAbsent(id, cluster);
                return String.format("Organism %s: Created cluster %s%n", organismName, id);
            }
        }
        return null;
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId
            , int health, int positionRow, int positionCol, int additionalProperty) {

        Cell cell = null;
        switch (cellType) {
            case "RedBloodCell":
                if (positionCol >= 0 && positionRow >= 0) {
                    cell = new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
                }
            case "WhiteBloodCell":
                if (positionCol >= 0 && positionRow >= 0) {
                    cell = new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
                }
            case "Bacteria":
                if (positionCol >= 0 && positionRow >= 0) {
                    cell = new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
                }
            case "Fungi":
                if (positionCol >= 0 && positionRow >= 0) {
                    cell = new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
                }
            case "Virus":
                if (positionCol >= 0 && positionRow >= 0) {
                    cell = new Virus(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
                }
        }

        if (this.organisms.containsKey(organismName)) {
            List<Map.Entry<String, Cluster>> filtered = this.organisms.get(organismName).getClusters()
                    .entrySet().stream().filter(cluster -> cluster.getValue().getId().equals(clusterId)).collect(Collectors.toList());
            if (filtered.size() > 0) {
                Cell finalCell = cell;
                filtered.forEach(cluster -> cluster.getValue().addCell(finalCell));
                return String.format("Organism %s: Created cell %s in cluster %s%n", organismName,
                        cellId, clusterId);
            }
        }

        return null;
    }

    public String activateCluster(String organismName) {
        if (!this.organisms.containsKey(organismName) || this.organisms.get(organismName).getClusters().size() < 1) {
            return null;
        }
        int index = 0;
        String clusterName = "";
        try {
            for (Cluster cluster : this.organisms.get(organismName).getClusters().values()) {
                clusterName = cluster.getId();
                Comparator<Cell> byRow = Comparator.comparing(Cell::getPositionRow);
                Comparator<Cell> byCol = Comparator.comparing(Cell::getPositionCol);
                List<Cell> sorted = cluster.getCells().stream().sorted(byRow.thenComparing(byCol)).collect(Collectors.toList());

                for (int i = 1; i < sorted.size(); i++) {
                    if (sorted.get(0) instanceof BloodCell) {
                        sorted.get(0).setHealth(sorted.get(0).getHealth() + sorted.get(i).getHealth());
                        sorted.get(0).setPositionRow(sorted.get(i).getPositionRow());
                        sorted.get(0).setPositionCol(sorted.get(i).getPositionCol());
                    } else {
                        while (true) {
                            sorted.get(i).setHealth(sorted.get(i).getHealth() - sorted.get(0).energy());
                            if (sorted.get(i).getHealth() <= 0) {
                                sorted.get(0).setPositionRow(sorted.get(i).getPositionRow());
                                sorted.get(0).setPositionCol(sorted.get(i).getPositionCol());
                                break;
                            }
                            sorted.get(0).setHealth(sorted.get(0).getHealth() - sorted.get(i).energy());
                            if (sorted.get(0).getHealth() <= 0) {
                                sorted.set(0, sorted.get(i));
                                break;
                            }
                        }
                    }
                }
                cluster.getCells().clear();
                cluster.addCell(sorted.get(0));
                break;
            }
        } catch (Exception e){ }

        Cluster cluster = this.organisms.get(organismName).getClusters().get(clusterName);

        this.organisms.get(organismName).getClusters().remove(clusterName);
        this.organisms.get(organismName).getClusters().putIfAbsent(clusterName,cluster);

        int size = cluster.getCells().size();
        return String.format("Organism %s: Activated cluster %s. Cells left: %d%n", organismName, cluster.getId(), size);
    }

}
