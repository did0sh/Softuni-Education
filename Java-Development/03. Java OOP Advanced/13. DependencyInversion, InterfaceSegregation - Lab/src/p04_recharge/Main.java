package p04_recharge;

public class Main {
    public static void main(String[] args) {
        BaseWorker empl = new Employee("5");
        BaseWorker robot = new Robot("7", 100, 50);

        ((Employee) empl).sleep();

        robot.work(4);
        ((Robot) robot).recharge();
        System.out.println(((Robot) robot).getCurrentPower());
    }
}
