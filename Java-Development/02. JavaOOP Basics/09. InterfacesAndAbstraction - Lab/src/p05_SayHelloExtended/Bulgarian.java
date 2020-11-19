package p05_SayHelloExtended;

public class Bulgarian extends BasePerson implements Person{
    private String name;

    protected Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
