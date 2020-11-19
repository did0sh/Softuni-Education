package p01_Weekdays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WeeklyCalendar {
    private List<WeeklyEntry> entries;

    public WeeklyCalendar() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(String weekday, String notes){
        WeeklyEntry entry = new WeeklyEntry(weekday, notes);
        this.entries.add(entry);
    }

    public Iterable<WeeklyEntry> getWeeklySchedule() {
        this.entries.sort(Comparator.comparingInt(e -> e.getWeekday().ordinal()));
        return this.entries;
    }
}
