package models.boats_engine;

import Utility.Constants;
import Utility.Validator;

public class SterndriveEngine extends BaseBoatEngine {
    private static final int MULTIPLIER = 7;

    public SterndriveEngine(String model, int horsePower, int displacement) {
        super(model, horsePower, displacement);
    }

    @Override
    protected int calculateCachedOutput(int horsepower, int displacement) {
        return  (horsepower * MULTIPLIER) + displacement;
    }

}
