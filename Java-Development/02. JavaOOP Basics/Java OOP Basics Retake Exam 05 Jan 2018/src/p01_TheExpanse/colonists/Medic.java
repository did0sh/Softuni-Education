package p01_TheExpanse.colonists;

import p01_TheExpanse.Colonist;

public abstract class Medic extends Colonist {
    private String sign;

    public Medic(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age);
        this.sign = sign;
    }


    @Override
    protected int getBonus() {
        return 2;
    }


    public String getSign() {
        return this.sign;
    }
}
