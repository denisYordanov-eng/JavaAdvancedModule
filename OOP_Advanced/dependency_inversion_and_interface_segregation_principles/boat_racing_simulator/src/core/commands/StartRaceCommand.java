package core.commands;

import exeptions.*;

public class StartRaceCommand extends BaseCommand{
    @Override
    public String execute() throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
        return super.getBoatSimulatorController().startRace();
    }
}
