package core.commands;

import engines.Engine;
import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;

public class CreatePowerBoatCommand extends BaseCommand {
    @Override
    public String execute() throws DuplicateModelException, NonExistantModelException {
        String model = super.getParams().get(0);
        int weight = Integer.parseInt(super.getParams().get(1));
        String firstEngineModel = super.getParams().get(2);
        String secondEngineModel = super.getParams().get(3);
        return getBoatSimulatorController().createPowerBoat(model, weight,firstEngineModel, secondEngineModel);
    }
}
