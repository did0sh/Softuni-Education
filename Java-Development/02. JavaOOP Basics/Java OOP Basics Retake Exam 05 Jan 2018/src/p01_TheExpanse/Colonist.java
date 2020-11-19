package p01_TheExpanse;

public abstract class Colonist {
    private String id;
    private String familyId;
    private int talent;
    private int age;

    protected Colonist(String id, String familyId, int talent, int age) {
        this.id = id;
        this.familyId = familyId;
        this.talent = talent;
        this.age = age;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public int getTalent() {
        return this.talent;
    }

    public int getAge() {
        return this.age;
    }

    public String getId() {
        return this.id;
    }

    public int getPotential(){
        return this.talent + this.getBonus();
    }

    protected abstract int getBonus();

    public void grow(int years){
        this.age += years;
    }

    @Override
    public String toString() {
        return this.getId() + ": " + this.getPotential();
    }
}
