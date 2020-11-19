package p04_recharge;

public abstract class BaseWorker {

    private String id;
    private int workingHours;

    public BaseWorker(String id) {
        this.id = id;
    }

    public void work(int hours) {
        this.workingHours += hours;
    }
}
