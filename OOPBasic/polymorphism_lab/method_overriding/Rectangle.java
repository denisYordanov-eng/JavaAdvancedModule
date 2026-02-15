package method_overriding;

public class Rectangle {
    private Double sideA;
    private Double sideB;

    public Rectangle(Double sideA, Double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Rectangle(Double sideA) {
        this.sideA = sideA;
    }

    public double area() {
        return sideA * sideB;
    }

    public double getSideA() {
        return sideA;
    }
}
