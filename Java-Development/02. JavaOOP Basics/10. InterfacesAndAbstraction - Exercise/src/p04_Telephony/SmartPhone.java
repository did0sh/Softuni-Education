package p04_Telephony;

public class SmartPhone implements Browsable, Callable {

    public SmartPhone() {
    }

    @Override
    public String browse() {
        return "Browsing: ";
    }

    @Override
    public String call() {
        return "Calling... ";
    }
}
