package p06_BirthdayCelebrations;

public class Citizen implements Identifiable, Birthable {
    private String name;
    private int age;
    private String id;
    private String birthDay;

    public Citizen(String name, int age, String id, String birthDay) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDay = birthDay;
    }



    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthday() {
        return this.birthDay;
    }
}
