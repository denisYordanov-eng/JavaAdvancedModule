package DefiningClass_Exercises.RawData;

public class Car {
    private String model;
    private Cargo cargo;
    private Engine engine;
    private Tyres[] tyres;



    public Car(String model, int engineSpeed, int enginePower
            , int cargoWeight, String cargoType
            , double tyreOnePressure, int tyreOneYears, double tyreTwoPressure, int tyreTwoYears
            , double tyreThreePressure, int tyreThreeYears, double tyreFourPressure, int tyreFourYears) {

        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight,cargoType);
        this.tyres = new Tyres[4];

        tyres[0] = new Tyres(tyreOnePressure, tyreOneYears);
        tyres[1] = new Tyres(tyreTwoPressure, tyreTwoYears);
        tyres[2] = new Tyres(tyreThreePressure, tyreThreeYears);
        tyres[3] = new  Tyres(tyreFourPressure, tyreFourYears);
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tyres[] getTyres() {
        return tyres;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }
    @Override
    public String toString() {
      return String.format("%s",getModel());
    }
}
