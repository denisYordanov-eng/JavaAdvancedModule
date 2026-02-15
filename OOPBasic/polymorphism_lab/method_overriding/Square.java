package method_overriding;

public class Square extends Rectangle {
    public Square(Double sideA) {
        super(sideA);
    }

    @Override
    public double area() {
        return this.getSideA() * this.getSideA();
    }

}
