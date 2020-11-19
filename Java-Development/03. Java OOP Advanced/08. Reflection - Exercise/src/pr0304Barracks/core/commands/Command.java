package pr0304Barracks.core.commands;

public abstract class Command implements pr0304Barracks.contracts.Executable {
    private String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    public String[] getData() {
        return this.data;
    }
}
