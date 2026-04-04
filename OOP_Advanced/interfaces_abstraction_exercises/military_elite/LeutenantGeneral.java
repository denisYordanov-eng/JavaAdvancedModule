package military_elite;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LeutenantGeneral extends SoldierImpl implements ILeutenantGeneral {
    private double salary;
    private Set<IPrivate> privateImpls;

    public LeutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
        this.privateImpls = new TreeSet<>((p1, p2) -> Integer.compare(p2.getId(), p1.getId()));
    }


    @Override
    public Set<IPrivate> getPrivateImpls() {
        return this.privateImpls;
    }

    @Override
    public void addPrivateImpl(IPrivate privateSoldier) {
        this.privateImpls.add(privateSoldier);
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f"
                , super.getFirstName()
                , super.getLastName()
                , super.getId()
                , this.salary));
        sb.append(System.lineSeparator());
        sb.append("Privates:");
                for (IPrivate p : this.privateImpls) {
                    sb.append(System.lineSeparator());
                    sb.append("  ");
                    sb.append(p);
                };
        return sb.toString().trim();
    }
}
