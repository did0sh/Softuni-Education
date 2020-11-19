package p02_WarningLevels;

public class Message {
    private Importance importance;
    private String message;

    public Message(String importance, String message) {
        this.importance = Enum.valueOf(Importance.class, importance);
        this.message = message;
    }

    public Importance getImportance() {
        return this.importance;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %s", this.getImportance(), this.getMessage()));
        return sb.toString();
    }
}
