package p07_ManKind.models;

import p07_ManKind.interfaces.Nameable;

public abstract class Human implements Nameable {
    private String firstName;
    private String lastName;

   protected Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setFirstName(String firstName) {
        if (firstName.charAt(0) == firstName.toLowerCase().charAt(0)){
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        } else if(firstName.length() < 4){
            throw new IllegalArgumentException("Expected length at least 4 symbols! Argument: firstName");
        }
        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        if (lastName.charAt(0) == lastName.toLowerCase().charAt(0)){
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        } else if(lastName.length() < 3){
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return String.format("First Name: %s%nLast Name: %s", this.getFirstName(), this.getLastName());
    }
}
