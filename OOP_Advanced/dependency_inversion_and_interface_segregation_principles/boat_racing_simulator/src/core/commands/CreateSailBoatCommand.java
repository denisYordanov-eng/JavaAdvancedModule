package core.commands;

import exeptions.DuplicateModelException;

public class CreateSailBoatCommand extends BaseCommand{

    @Override
    public String execute() throws DuplicateModelException {
        String model = super.getParams().get(0);
        int weight = Integer.parseInt(super.getParams().get(1));
        int sailEfficiency = Integer.parseInt(super.getParams().get(2));
        return getBoatSimulatorController().createSailBoat(model, weight, sailEfficiency);
    }
}
