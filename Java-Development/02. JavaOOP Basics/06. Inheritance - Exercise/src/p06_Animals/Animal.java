package p06_Animals;

public class Animal {
    private static final String DEFAULT_INVALID_EXCEPTION = "Invalid input!";
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException(DEFAULT_INVALID_EXCEPTION);
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 1){
            throw new IllegalArgumentException(DEFAULT_INVALID_EXCEPTION);
        }
        this.age = age;
    }

    private void setGender(String gender) {
        if (gender.trim().isEmpty()){
            throw new IllegalArgumentException(DEFAULT_INVALID_EXCEPTION);
        }
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public String produceSound(){
        return "Not implemented!";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + System.lineSeparator() + this.getName() + " " + this.getAge() + " " + this.getGender();
    }

}
