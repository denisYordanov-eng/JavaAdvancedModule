package shapes;

public class Rectangle extends Shape {
    private double height;

    private double width;

    public Rectangle(double width, double height) {
        setHeight(height);
        setWidth(width);
        this.calculateArea();
        this.calculatePerimeter();
    }

    public final double getHeight() {
        return height;
    }

    public final double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    protected void calculateArea() {
        setArea(getHeight() * getWidth());
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter((2 * getHeight()) + (2 * getWidth()));
    }
}
