package military_elite;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Commando extends SpecialisedSoldierImpl implements IComando {
    private Set<Mission> missions;

    public Commando(String firstName, String lastName, int id, double salary, String corps) {
        super(firstName, lastName, id, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    @Override
    public Set<Mission> getMissions() {
        return Collections.unmodifiableSet(missions);
    }

    @Override
    public void addMission(Mission mission) {
        if (mission.getMissionState() != null) {
            missions.add(mission);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(System.lineSeparator());
        sb.append("Missions:");
        for (IMission mission : missions) {
            sb.append(System.lineSeparator());
            sb.append("  ");
            sb.append(mission.toString());
        }

        return sb.toString();
    }
}
