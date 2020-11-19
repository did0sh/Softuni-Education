package p01_TheExpanse.colonists;

public class GeneralPractitioner extends Medic {


    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getBonus() {
        int bonus = 0;
        if (super.getAge() > 15){
            bonus += 1;
        }

        if (super.getSign().equals("caring")){
            bonus += 1;
        } else if (super.getSign().equals("careless")){
            bonus -= 2;
        }

        return super.getBonus() + bonus;
    }

}
