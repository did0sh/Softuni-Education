package p01_TheExpanse.colonists;

import p01_TheExpanse.Colonist;

public class Soldier extends Colonist {

    public Soldier(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getBonus() {
        return 6;
    }

}
