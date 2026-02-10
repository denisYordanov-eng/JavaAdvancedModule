package inheritance_exercises.mankind;

public class Worker extends Human {
    private double weekSalary;

    private double workingHoursPerDay;

    public Worker(String firstName, String lastName,double weekSalary, double workingHoursPerDay) {
        super(firstName, lastName);
        setWeekSalary(weekSalary);
        setWorkingHoursPerDay(workingHoursPerDay);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkingHoursPerDay(double workingHoursPerDay) {
        if (workingHoursPerDay <= 0 || workingHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workingHoursPerDay = workingHoursPerDay;
    }

    private double calculateSalaryPerHour() {
        return weekSalary / (workingHoursPerDay * 7);
    }

    @Override
    protected void setLastName(String lastName) {
        if(lastName.length() <= 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("First Name: %s", super.getFirstName()));
        builder.append(System.lineSeparator());
        builder.append(String.format("Last Name: %s", super.getLastName()));
        builder.append(System.lineSeparator());
        builder.append(String.format("Week Salary: %.2f", this.weekSalary));
        builder.append(System.lineSeparator());
        builder.append(String.format("Hours per day: %.2f", this.workingHoursPerDay));
        builder.append(System.lineSeparator());
        builder.append(String.format("Salary per hour: %.2f", calculateSalaryPerHour()));
        return builder.toString();
    }
}
