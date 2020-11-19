package p01_TheExpanse;

import java.util.*;

public class Colony {
    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private Map<String, Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families = new HashMap<>();
    }

    public int getMaxFamilyCount() {
        return this.maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return this.maxFamilyCapacity;
    }

    public List<Colonist> getColonistsByFamilyId(String familyId){
        return this.families.get(familyId).getColonists();
    };

    public void addColonist(Colonist colonist){
        String familyId = colonist.getFamilyId();
        Family family = this.families.get(familyId);
        if (family == null){
            if (this.getMaxFamilyCount() <= this.families.size()){
                throw new IllegalArgumentException("colony is full");
            }
            family = new Family(familyId);
        }

        if (this.getMaxFamilyCapacity() == family.getColonists().size()){
            throw new IllegalArgumentException("family is full");
        }
        family.addColonist(colonist);
        this.families.put(familyId, family);
    }

    public void removeColonist(String familyId, String colonistId) {
        Family family = this.families.get(familyId);
        if (family != null){
            family.removeColonist(colonistId);
            if (family.getColonists().size() == 0){
                this.removeFamily(familyId);
            }
        }
    }

    public void removeFamily(String id){
        this.families.remove(id);
    }

    public void grow(int years){
        this.families.values().stream().flatMap(f -> f.getColonists().stream())
                .forEach(colonist -> colonist.grow(years));
    }

    public int getPotential(){
        return this.families.values().stream().flatMap(f -> f.getColonists().stream())
                .mapToInt(Colonist::getPotential).sum();
    }

    public String getCapacity(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("families: %d/%d", this.families.size(), this.maxFamilyCount))
                .append(System.lineSeparator());
        this.families.values().stream()
                .sorted(Comparator.comparing(Family::getId))
                .forEach(family -> {
                    sb.append(String.format("-%s: %d/%d"
                            , family.getId()
                            , family.getColonists().size()
                            , this.getMaxFamilyCapacity()))
                            .append(System.lineSeparator());
                });
        return sb.toString().trim();
    }

    public Family getFamilyById(String familyId) {
        return this.families.get(familyId);
    }

}
