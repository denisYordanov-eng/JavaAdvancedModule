package random_arraylist;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<String> ral = new RandomArrayList<>();
        ral.add("A");
        ral.add("B");
        ral.add("C");
        ral.add("D");
        ral.add("1");
        ral.add("2");
        ral.add("3");
        ral.add("4");
        System.out.println(ral.getRandomElement());
        System.out.println(ral);
    }
}
