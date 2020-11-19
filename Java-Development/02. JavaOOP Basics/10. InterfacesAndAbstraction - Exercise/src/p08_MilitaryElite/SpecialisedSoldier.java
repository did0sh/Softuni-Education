package p08_MilitaryElite;

public abstract class SpecialisedSoldier extends Private{
    private String corps;

    public SpecialisedSoldier(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    protected String getCorps() {
        return this.corps;
    }
}
