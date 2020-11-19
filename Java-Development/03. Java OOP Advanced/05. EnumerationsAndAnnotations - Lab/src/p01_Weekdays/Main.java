package p01_Weekdays;

public class Main {
    public static void main(String[] args) {
        WeeklyCalendar weeklyCalendar = new WeeklyCalendar();

        weeklyCalendar.addEntry("Friday", "sleep");
        weeklyCalendar.addEntry("Monday", "sport");

        Iterable<WeeklyEntry> schedule = weeklyCalendar.getWeeklySchedule();

        for (WeeklyEntry entry : schedule) {
            System.out.println(entry);
        }
    }
}
