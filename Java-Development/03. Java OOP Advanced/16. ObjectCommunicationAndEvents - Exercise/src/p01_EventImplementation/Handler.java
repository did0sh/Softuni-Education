package p01_EventImplementation;

public class Handler implements NameChangeListener {
    private NameChange event;

    public Handler(NameChange event) {
        this.event = event;
    }

    @Override
    public void handleChangedName() {
        System.out.printf("Dispatcher's name changed to %s.%n", this.event.getChangedName());
    }
}
