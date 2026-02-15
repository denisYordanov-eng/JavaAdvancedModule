package shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        setRadius(radius);
        this.calculateArea();
        this.calculatePerimeter();
    }

    public final double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculateArea() {
        setArea(2 * Math.PI * getRadius());
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * Math.PI * radius);
    }
}
