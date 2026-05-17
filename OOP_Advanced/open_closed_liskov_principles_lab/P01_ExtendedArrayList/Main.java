package P01_ExtendedArrayList;


public class Main {
    public static void main(String[] args) {
        ExtendedArrayListable<Integer> list = new ExtendedArrayList<>();
        list.add(1);
        list.add(2);
        list.add(10);
        list.add(-20);

        System.out.println(list.max());
        System.out.println(list.min());

    }
}
