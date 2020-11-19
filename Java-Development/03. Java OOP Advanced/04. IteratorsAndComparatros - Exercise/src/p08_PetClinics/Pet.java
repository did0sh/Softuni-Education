package p08_PetClinics;

public class Pet {
    private String name;
    private int age;
    private String kind;

    public Pet(String name, int age, String kind) {
        this.setName(name);
        this.setAge(age);
        this.setKind(kind);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getKind() {
        return this.kind;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %d %s", this.getName(), this.getAge(), this.getKind()));
        return sb.toString();
    }
}
