package p05_SayHelloExtend.models;

import p05_SayHelloExtend.contracts.Person;

public abstract class BasePerson implements Person {
    private String name;

    protected BasePerson(String name) {
        this.setName(name);
    }

    private void setName(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }
}
