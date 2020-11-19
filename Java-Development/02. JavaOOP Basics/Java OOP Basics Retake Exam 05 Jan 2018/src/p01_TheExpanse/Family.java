package p01_TheExpanse;


import java.util.*;

public class Family  {
    private String id;
    private Map<String,Colonist> colonists;

    public Family(String id) {
        this.id = id;
        this.colonists = new HashMap<>();
    }

    public String getId() {
        return this.id;
    }

    public List<Colonist> getColonists() {
        return Collections.unmodifiableList(new ArrayList<>(this.colonists.values()));
    }

    public void addColonist(Colonist colonist) {
        this.colonists.put(colonist.getId(), colonist);
    }

    public void removeColonist(String id) {
        this.colonists.remove(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id).append(":").append(System.lineSeparator());
        this.colonists.values().stream()
                .sorted(Comparator.comparing(Colonist::getId))
                .forEach(c -> sb.append("-").append(c).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
