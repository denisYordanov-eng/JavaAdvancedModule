package generic_swap_method_integers;

public class Box<T extends Number> {
    private T item;

    public Box(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item.getClass().getName() + ": " + this.item;
    }
}
