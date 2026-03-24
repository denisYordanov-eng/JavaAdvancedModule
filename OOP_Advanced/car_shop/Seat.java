package car_shop;

public class Seat implements Car{

    private  String model;
    private  String color;
    private  Integer horsePower;
    private String country;

    public Seat(String model, String color, Integer horsePower, String country) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.country = country;
    }
    //-countryProduced: String
    public String getCountryProduced() {
        return this.country;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String toString() {
        return "This is Leon produced in Spain and have 4 tires";
    }
}
