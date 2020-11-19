package p09_Animals.abstractClasses;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
            this.name = name;
    }

    private void setAge(int age) {
        if (age < 1){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private void setGender(String gender) {
        if (gender.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
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

    public String produceSound() {
        return "Not implemented!";
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s",
                this.getClass().getSimpleName(), this.getName(), this.getAge(), this.getGender());
    }
}
