package core.commands;

import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;
import exeptions.RaceAlreadyExistsException;

public class OpenRaceCommand extends BaseCommand{
    @Override
    public String execute() throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException {
        int distance = Integer.parseInt(super.getParams().get(0));
        int windSpeed = Integer.parseInt(super.getParams().get(1));
        int oceanCurrentSpeed = Integer.parseInt(super.getParams().get(2));
        boolean allowsMotorSports = Boolean.parseBoolean(super.getParams().get(3));
        return super.getBoatSimulatorController().openRace(distance,windSpeed,oceanCurrentSpeed,allowsMotorSports);
    }
}
