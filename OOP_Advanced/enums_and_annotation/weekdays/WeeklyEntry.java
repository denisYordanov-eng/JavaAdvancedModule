package weekdays;

public class WeeklyEntry implements Comparable<WeeklyEntry>{
    private Weekday weekDay;
    private String note;

    public WeeklyEntry(String weekDay, String note) {
        this.weekDay = Enum.valueOf(Weekday.class, weekDay.toUpperCase());
        this.note = note;
    }


    @Override
    public String toString() {
        return String.format("%s - %s", weekDay, note);
    }

    @Override
    public int compareTo(WeeklyEntry day) {
        return this.weekDay.compareTo(day.weekDay);
    }
}
