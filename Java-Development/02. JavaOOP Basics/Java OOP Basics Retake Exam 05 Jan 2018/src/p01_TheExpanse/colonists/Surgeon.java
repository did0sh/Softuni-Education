package p01_TheExpanse.colonists;

public class Surgeon extends Medic {


    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getBonus() {
        int bonus = 0;
       if (super.getAge() > 25 && super.getAge() < 35){
           bonus += 2;
       }

       if (super.getSign().equals("precise")){
           bonus += 3;
       } else if (super.getSign().equals("butcher")){
           bonus -= 3;
       }

       return super.getBonus() + bonus;
    }

}
