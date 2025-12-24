package AsynchronousProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ResponsiveUi_03 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int n = Integer.parseInt(scanner.nextLine());

        Runnable task =() ->{
            printPrimes(n);
        };
        //initialize the task and start the task.
        Thread thread = new Thread(task);
        thread.start();
        //while thread calculating, scanner waits to type "stop"  and then will stop the execution
        while (true) {
          String command  = scanner.nextLine();
            if (command.equals("stop")) {
                thread.interrupt();
                break;
            }else {
                System.out.println("unknown command");
            }
        }
        thread.join();
    }
    static void printPrimes(int n){
        List<Integer> primes = new ArrayList<>();
        for (int currentNumber = 0; currentNumber <= n; currentNumber++) {
            if(isPrime(currentNumber)){
                primes.add(currentNumber);
            }
            //if you type "stop", you will interrupt current thread and go into this if statement and break the cycle
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted...");
                break;
            }
        }
        System.out.println(primes.stream()
                .limit(10)
                .collect(Collectors.toList()) + "...");
        System.out.printf("%s primes calculated.", primes.size());
    }

    static boolean isPrime(int n){
       if(n == 1) {
           return false;
       }
       for (int i = 2; i <= Math.sqrt(n); i++) {
           if(n % i == 0) {
               return false;
           }
       }
       return true;
    }
}
