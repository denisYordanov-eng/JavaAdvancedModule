package generic_box_of_integer;

public class Box<T> {
    private T input;
    public Box(T input) {
        this.input = input;
    }
    @Override
    public String toString() {
        return input.getClass().getName() +": " + input.toString();
    }
}
