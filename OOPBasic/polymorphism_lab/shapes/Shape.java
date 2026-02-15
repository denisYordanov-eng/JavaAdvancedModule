package shapes;

public abstract class Shape {
    private double perimeter;
    private double area;

    public double getPerimeter() {
        return this.perimeter;
    }

    public double getArea() {
        return this.area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    protected abstract void calculateArea();

    protected abstract void calculatePerimeter();

}
