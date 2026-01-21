package DefiningClass_Exercises.CarSalesman;

public class Engine {
    private String type;

    private int power;

    private Integer displacement;

   private String efficiency;

    public Engine(String type, int power) {
        this.type = type;
        this.power = power;
    }


    public Engine(String type,int power,Integer displacement,String efficiency) {
        this.type = type;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getType() {
        return type;
    }

    public int getPower() {
        return power;
    }

    public Integer getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
