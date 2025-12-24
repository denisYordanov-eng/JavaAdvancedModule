package AsynchronousProgramming.Transactions_05;

public class Transactions_Main {
    public static void main(String[] args) throws InterruptedException {
        //make an object of account
        Account account = new Account();

        //make a task  100 times call account increment method with parameter of 1;
        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                account.increment(1);
                //allow to run another thread during the running
                Thread.yield();
            }
        };
        //make thead array and initialize 100 threads
        Thread[] threads = new Thread[100];

        //make for loop and initialize each thead and give it the task, then start the tread
        //cannot use foreach loop because it uses referential of the object thread, and it doesn't save the thread
        // gives a null point exception
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }
        //in foreach loop join the finish threads
        for (Thread thread : threads) {
            thread.join();
        }
        //print the object.balance
        System.out.println(account.balance);
    }
}
