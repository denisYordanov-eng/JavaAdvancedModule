package car_shop_extend;



public class Audi implements Rentable{
    private String model;
    private String color;
    private Integer horsePower;
    private String country;
    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower
            , String country, Integer minRentDay, Double pricePerDay) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.country = country;
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
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
        return String.format("This is %s produced in %s and have %d tires"
                , this.getModel()
                , this.country
                , Car.TYRES);
    }
}
