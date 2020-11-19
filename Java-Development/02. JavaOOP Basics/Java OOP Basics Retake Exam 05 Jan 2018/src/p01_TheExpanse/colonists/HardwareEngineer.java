package p01_TheExpanse.colonists;

public class HardwareEngineer extends Engineer {


    public HardwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getBonus() {
        if (super.getAge() < 18){
            return super.getBonus() + 2;
        }
        return super.getBonus();
    }

}
