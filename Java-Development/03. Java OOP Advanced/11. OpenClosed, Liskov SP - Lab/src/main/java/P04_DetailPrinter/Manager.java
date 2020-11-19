package P04_DetailPrinter;

public class Manager extends Employee {

    private Iterable<String> documents;

    public Manager(String name, Iterable<String> documents) {
        super(name);
        this.documents = documents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("Documents: %s%n", String.join(", ",this.documents)));
        return sb.toString();
    }
}
