package math_operation;

public class Main {
    public static void main(String[] args) {
        //exploring overload methods
        MathOperation mathO = new MathOperation();

        System.out.println(mathO.add(2,2));
        System.out.println(mathO.add(3,3,3));
        System.out.println(mathO.add(4,4,4,4));
        System.out.println(mathO.add(2.5,2.5));
    }
}
