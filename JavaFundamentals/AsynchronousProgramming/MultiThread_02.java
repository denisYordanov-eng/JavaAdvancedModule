package AsynchronousProgramming;

public class MultiThread_02 {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.printf("[%s] ",i);
                //this method allows that current thread can make a pause and allow another thread to start
                Thread.yield();
            }
        };
        //make an array of threads and initialize 5 threads
        Thread[] threads = new Thread[5];

        //in for loop give the current thread task and start the current thread
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }
        // in foreach loop wait for the  current thread to finish
       for(Thread thread : threads){
           thread.join();
       }
    }
}
