package core.commands;

import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;

public class CreateYachtCommand extends BaseCommand {

    @Override
    public String execute() throws DuplicateModelException, NonExistantModelException {
        String model = getParams().get(0);
        int weight =  Integer.parseInt(getParams().get(1));
        String engineModel = getParams().get(2);
        int cargoWeight = Integer.parseInt(getParams().get(3));
        return getBoatSimulatorController().createYacht(model, weight, engineModel, cargoWeight);
    }
}
