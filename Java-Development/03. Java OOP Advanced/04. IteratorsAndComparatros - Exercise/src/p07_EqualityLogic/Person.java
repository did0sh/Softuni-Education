package p07_EqualityLogic;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Person)){
            return false;
        }

        Person person = (Person) obj;

        if (this.getAge() != person.getAge()){
            return false;
        }

        return this.getName() != null ? this.getName().equals(person.getName()) : person.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + this.getAge();
        result = 31 * result + this.getName().hashCode();

        return result;
    }

    @Override
    public int compareTo(Person o) {
        if (this.getName().compareTo(o.getName()) == 0){
            return this.getAge() - o.getAge();
        }

        return this.getName().compareTo(o.getName());
    }
}
