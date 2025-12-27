package AsynchronousProgramming.Deadlock_06;

public class DeadLock {
    public static void main(String[] args) {
        MyClass first = new MyClass("First");
        MyClass second = new MyClass("Second");

        Thread tFirst = new Thread(() -> {
        first.a(second);
        });

        Thread tSecond = new Thread(() -> {
            second.a(first);
        });

        tFirst.start();
        tSecond.start();
    }
}
