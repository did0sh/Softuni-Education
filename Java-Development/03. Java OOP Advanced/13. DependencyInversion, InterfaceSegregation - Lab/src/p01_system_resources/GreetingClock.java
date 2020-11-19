package p01_system_resources;

public class GreetingClock implements Greeting {

    private TimeProvider timeProvider;
    private Writer writer;

    public GreetingClock(TimeProvider timeProvider, Writer writer) {
        this.timeProvider = timeProvider;
        this.writer = writer;
    }

    @Override
    public void greeting() {
        if (this.timeProvider.getHour() < 12) {
            this.writer.writeLine("Good morning...");
        } else if (this.timeProvider.getHour() < 18) {
            this.writer.writeLine("Good afternoon...");
        } else {
            this.writer.writeLine("Good evening...");
        }
    }
}
