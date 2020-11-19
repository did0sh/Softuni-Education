package p01_Weekdays;

public class WeeklyEntry {
    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.weekday = Enum.valueOf(Weekday.class, weekday.toUpperCase());
        this.notes = notes;
    }

    public Weekday getWeekday() {
        return this.weekday;
    }

    public String getNotes() {
        return this.notes;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %s", this.getWeekday(), this.getNotes()));
        return sb.toString();
    }
}
