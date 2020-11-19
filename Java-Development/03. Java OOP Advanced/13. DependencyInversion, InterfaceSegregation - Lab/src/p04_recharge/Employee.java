package p04_recharge;

public class Employee extends BaseWorker implements Sleeper {

    private String id;

    public Employee(String id) {
        super(id);
    }

    @Override
    public void sleep() {
        System.out.println("Employee is sleeping");
    }
}
