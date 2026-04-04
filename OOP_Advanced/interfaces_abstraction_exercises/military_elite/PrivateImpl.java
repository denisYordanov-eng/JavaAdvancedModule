package military_elite;

public class PrivateImpl extends SoldierImpl implements ISoldier, IPrivate {
    private double salary;

    public PrivateImpl(String firstName, String lastName, int id, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s Salary: %.2f"
                , super.getFirstName()
                , super.getLastName()
                , super.getId()
                , this.getSalary());
    }
}
