package military_elite;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Engineer extends SpecialisedSoldierImpl implements IEngineer {

    private Set<IRepair> repairs;

    public Engineer(String firstName, String lastName, int id, double salary, String corps) {
        super(firstName, lastName, id, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }


    @Override
    public Set<IRepair> getRepairs() {
        return Collections.unmodifiableSet(repairs);
    }

    @Override
    public void addRepair(IRepair repair) {
        repairs.add(repair);
    }

    @Override
    public String getCorps() {
        return super.getCorps();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(System.lineSeparator());
        sb.append("Repairs:");
        for (IRepair repair : repairs) {
            if (repair != null) {
                sb.append(System.lineSeparator());
                sb.append(repair.toString());
            }
        }
        return sb.toString();
    }
}
