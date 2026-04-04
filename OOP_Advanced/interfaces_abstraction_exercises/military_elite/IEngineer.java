package military_elite;

import java.util.Set;

public interface IEngineer {
    Set<IRepair> getRepairs();
    void addRepair(IRepair repair);
    String getCorps();
}
