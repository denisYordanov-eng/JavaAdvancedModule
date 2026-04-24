package weekdays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WeeklyCalendar {
    private List<WeeklyEntry> weeklyEntries;

    public WeeklyCalendar() {
        this.weeklyEntries = new ArrayList<>();
    }

    public  void addEntry(String weekDay, String note) {
        this.weeklyEntries.add(new WeeklyEntry(weekDay, note));
    }
    public Iterable<WeeklyEntry> getWeeklySchedule() {
        this.weeklyEntries.sort(Comparator.naturalOrder());
        return this.weeklyEntries;
    }
}
