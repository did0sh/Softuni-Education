package p01_TheExpanse.colonists;

import p01_TheExpanse.Colonist;

public abstract class Engineer extends Colonist {

    protected Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getBonus() {
       if (super.getAge() > 30){
           return 5;
       }
       return 3;
    }

}
