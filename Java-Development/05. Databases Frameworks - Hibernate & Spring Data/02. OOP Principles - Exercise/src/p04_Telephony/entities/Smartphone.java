package p04_Telephony.entities;

import p04_Telephony.interfaces.Browsable;
import p04_Telephony.interfaces.Callable;

public class Smartphone implements Callable, Browsable {

    public Smartphone() {
    }

    @Override
    public String browse(String url) {
        if (url.matches(".*\\d.*")){
            return "Invalid URL!";
        } else {
            return String.format("Browsing: %s!", url);
        }
    }

    @Override
    public String call(String number) {
        if (number.matches(".*[A-Za-z].*")){
            return "Invalid number!";
        } else {
            return String.format("Calling... %s", number);
        }
    }
}
