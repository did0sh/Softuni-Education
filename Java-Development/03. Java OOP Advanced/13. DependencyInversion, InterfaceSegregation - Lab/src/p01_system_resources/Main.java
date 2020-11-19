package p01_system_resources;

public class Main {
    public static void main(String[] args) {
        TimeProvider timeProvider = new TimeProviderImpl();
        Writer writer = new ConsoleWriter();

        Greeting greetingClock = new GreetingClock(timeProvider, writer);
        greetingClock.greeting();
    }
}
