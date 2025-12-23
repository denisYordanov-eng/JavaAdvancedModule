package AsynchronousProgramming;

public class SingleThread_01 {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 1; i <= 10; i++) {
                System.out.printf("%d ", i);
            }
        };

        Thread thread = new Thread(task);
        //start the thread

        thread.start();
        //wait for the thread to finish
        thread.join();

        //exit the program
        System.exit(1);
    }
}
