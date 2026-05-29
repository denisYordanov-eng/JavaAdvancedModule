package models.boats_engine;

import Utility.Constants;
import Utility.Validator;
import contracts.BoatEngine;

public abstract class BaseBoatEngine implements BoatEngine {
    protected int cachedOutput;

    private String model;

    protected BaseBoatEngine( String model,int horsePower, int displacement) {
        this.setModel(model);
        this.validateHorsepower(horsePower);
        this.validateDisplacement(displacement);
      this.cachedOutput = this.calculateCachedOutput(horsePower,displacement);
    }

    @Override
    public String getModel() {
        return this.model;
    }


    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MinBoatEngineModelLength);
        this.model = model;
    }


    private void validateHorsepower(int horsepower) {
        Validator.validatePropertyValue(horsepower, "Horsepower");
    }

    private void validateDisplacement(int displacement) {
        Validator.validatePropertyValue(displacement, "Displacement");
    }

    public int getCachedOutput() {
        return cachedOutput;
    }

    protected abstract int calculateCachedOutput(int horsepower, int displacement);

}
