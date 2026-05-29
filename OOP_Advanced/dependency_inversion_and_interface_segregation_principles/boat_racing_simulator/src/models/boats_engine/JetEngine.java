package models.boats_engine;

public class JetEngine extends BaseBoatEngine {
    private static final int MULTIPLIER = 5;


    public JetEngine(String model, int horsePower, int displacement) {
        super(model, horsePower, displacement);
    }

    @Override
    public int calculateCachedOutput(int horsepower, int displacement){
       return  (horsepower * MULTIPLIER) + displacement;
    }






}
