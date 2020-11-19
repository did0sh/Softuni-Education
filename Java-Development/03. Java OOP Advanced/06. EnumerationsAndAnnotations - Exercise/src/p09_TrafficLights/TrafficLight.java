package p09_TrafficLights;

public class TrafficLight {
    private Signal signal;

    public TrafficLight(Signal signal) {
        this.signal = signal;
    }

    public Signal update(){
        int currentOrdinal = this.signal.ordinal();
        Signal[] signals = Signal.values();
        this.signal = signals[(currentOrdinal+1) % 3];
        return this.signal;
    }
}
