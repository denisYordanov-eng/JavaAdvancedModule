package p01_system_resources;


public class Main {
    public static void main(String[] args) {
       TimeProvider time = new TestTime();
       Writer writer = new ConsoleWriter();
        GreetingClock greetingClock = new GreetingClock(time, writer);
        greetingClock.greeting();
    }
}
