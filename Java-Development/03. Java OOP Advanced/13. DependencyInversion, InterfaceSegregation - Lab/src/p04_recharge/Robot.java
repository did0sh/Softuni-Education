package p04_recharge;

public class Robot extends BaseWorker implements Rechargeable {

    private String id;
    private int capacity;
    private int currentPower;

    public Robot(String id, int capacity, int currentPower) {
        super(id);
        this.capacity = capacity;
        this.setCurrentPower(currentPower);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentPower() {
        return currentPower;
    }

    private void setCurrentPower(int currentPower) {
        this.currentPower = currentPower;
    }

    @Override
    public void work(int hours) {
        if (hours > this.currentPower) {
            hours = currentPower;
        }

        super.work(hours);
        this.currentPower -= hours;
    }

    @Override
    public void recharge() {
        this.currentPower = this.capacity;
    }
}
