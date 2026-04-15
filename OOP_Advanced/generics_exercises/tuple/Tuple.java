package tuple;

public class Tuple <K, V>{
    private  K itemOne;
    private  V itemTwo;
    public Tuple(K itemOne, V itemTwo) {
        this.itemOne = itemOne;
        this.itemTwo = itemTwo;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", itemOne, itemTwo);
    }
}
