package p05_SayHelloExtended;

public class Chinese extends BasePerson implements Person{
    private String name;

    protected Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
