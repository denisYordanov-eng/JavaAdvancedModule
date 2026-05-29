package core.commands;

import exeptions.*;

public class CreateBoatEngineCommand extends BaseCommand{
    @Override
    public String execute() throws DuplicateModelException {
        String model = super.getParams().get(0);
        int horsePower = Integer.parseInt(super.getParams().get(1));
        int displacement = Integer.parseInt(super.getParams().get(2));
        String engineType = super.getParams().get(3);

        return super.getBoatSimulatorController().createBoatEngine(model,horsePower
                , displacement,engineType);
    }
}
