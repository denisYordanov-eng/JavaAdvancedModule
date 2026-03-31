package ferrari;

public class Ferrari implements Car {
    private  String driver;
    private  String model;

    public Ferrari(String driver) {
        this.driver = driver;
        this.model = "488-Spider";
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushTheGas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s%n"
                ,this.model
                ,useBrakes()
        ,pushTheGas()
        ,this.driver);
    }
}
