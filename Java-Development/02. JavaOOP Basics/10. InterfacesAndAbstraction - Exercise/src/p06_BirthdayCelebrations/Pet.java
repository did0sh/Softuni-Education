package p06_BirthdayCelebrations;

public class Pet implements Birthable {
    private String name;
    private String birthDay;

    public Pet(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    @Override
    public String getBirthday() {
        return this.birthDay;
    }

}
