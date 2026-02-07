package fragileBaseClass;

public class Main {
    public static void main(String[] args) {
        Predator p = new Predator();
        p.feed(new Food());
        System.out.println(p.getHealth());


    }
}
