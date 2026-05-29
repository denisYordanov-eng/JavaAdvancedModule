package models.boats;

import Utility.Validator;
import contracts.Race;

public class RowBoat extends BaseBoat{
    private int oars;
    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }



    private void setOars(int oars) {
        Validator.validatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (this.oars * 100) - super.getWeight() + race.getOceanCurrentSpeed();
    }

    @Override
    public boolean hasEngine() {
        return false;
    }
}
