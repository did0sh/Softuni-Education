package p05_SayHelloExtended;

public class European extends BasePerson implements Person{
    private String name;

    protected European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
