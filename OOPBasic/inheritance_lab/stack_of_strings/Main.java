package stack_of_strings;

public class Main {
    public static void main(String[] args) {
        StackOfStrings sos = new StackOfStrings();
        sos.push("One");
        sos.push("Two");
        sos.push("Three");
        sos.push("Four");
        sos.push("Five");
        sos.push("Six");
        sos.push("Seven");
        try {
            System.out.println(sos.pop());
            System.out.println(sos.peek());
            System.out.println(sos.isEmpty());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
