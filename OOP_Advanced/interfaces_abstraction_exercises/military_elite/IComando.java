package military_elite;

import java.util.Set;

public interface IComando  {
  Set<Mission> getMissions();
  void addMission(Mission mission);
}
