package core.commands;

import exeptions.DuplicateModelException;
import exeptions.NoSetRaceException;
import exeptions.NonExistantModelException;
import exeptions.RaceAlreadyExistsException;

public class SignUpBoatCommand extends BaseCommand {

    @Override
    public String execute() throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException {
        String model = super.getParams().get(0);
        return  super.getBoatSimulatorController().signUpBoat(model);
    }
}
