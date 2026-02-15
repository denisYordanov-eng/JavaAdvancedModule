package shapes;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2, 10);
        System.out.printf("%.2f%n", rectangle.getPerimeter());
        System.out.printf("%.2f%n", rectangle.getArea());

        Circle circle = new Circle(2);
        System.out.printf("%.2f%n", circle.getPerimeter());
        System.out.printf("%.2f%n", circle.getArea());
    }
}
