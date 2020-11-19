package p08_MilitaryElite;

public class Spy extends Private {
    private String codeNumber;
    public Spy(String id, String firstName, String lastName, double salary, String codeNumber) {
        super(id, firstName, lastName, salary);
        this.codeNumber = codeNumber;
    }

    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %s%n", super.getFirstName(),
                super.getLastName(), super.getId()));
        sb.append(String.format("Code Number: %s%n", this.getCodeNumber()));
        return sb.toString();
    }
}
