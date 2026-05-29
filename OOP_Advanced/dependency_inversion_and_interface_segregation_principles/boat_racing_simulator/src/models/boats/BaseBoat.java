package models.boats;

import Utility.Constants;
import Utility.Validator;
import contracts.Boat;


public abstract class BaseBoat implements Boat {
    private String model;
    private int weight;

    protected BaseBoat(String model, int weight) {
        setModel(model);
        setWeight(weight);
    }

    public String getModel() {
        return this.model;
    }

    public int getWeight() {
        return this.weight;
    }

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MinBoatModelLength);
        this.model = model;
    }

    private void setWeight(int weight) {
        Validator.validatePropertyValue(weight, "Weight");
        this.weight = weight;
    }


}
