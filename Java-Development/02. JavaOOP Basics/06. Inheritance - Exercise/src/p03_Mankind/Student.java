package p03_Mankind;

public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() < 5 || facultyNumber.length() > 10){
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = facultyNumber;
    }

    public String getFacultyNumber() {
        return this.facultyNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("First Name: %s%n", super.getFirstName()))
                .append(String.format("Last Name: %s%n", super.getLastName()))
                .append(String.format("Faculty number: %s%n", this.getFacultyNumber()));
        return sb.toString();
    }
}
