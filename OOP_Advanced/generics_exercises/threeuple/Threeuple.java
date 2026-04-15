package threeuple;

public class Threeuple<T, K, V> {
    private T itemOne;
    private K itemTwo;
    private V itemThree;


    public Threeuple(T itemOne, K itemTwo, V itemThree) {
        setItemOne(itemOne);
        setItemTwo(itemTwo);
        setItemThree(itemThree);
    }

    public T getItemOne() {
        return itemOne;
    }

    public void setItemOne(T itemOne) {
        this.itemOne = itemOne;
    }

    public K getItemTwo() {
        return itemTwo;
    }

    public void setItemTwo(K itemTwo) {
        this.itemTwo = itemTwo;
    }

    public V getItemThree() {
        return itemThree;
    }


    public void setItemThree(V itemThree) {
            this.itemThree = itemThree;
    }

    @Override
    public String toString() {
        return
                this.getItemOne() +" -> " + this.getItemTwo() +" -> " +this.getItemThree();

    }
}
