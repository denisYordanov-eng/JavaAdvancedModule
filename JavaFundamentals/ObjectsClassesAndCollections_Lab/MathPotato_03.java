package ObjectsClassesAndCollections_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MathPotato_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> queue = fillCollection(br);
        int n = readNumber(br);
        String lastName = findLastName(queue, n);
        printLastName(lastName);
    }

    private static void printLastName(String lastName) {
        System.out.println("Last is " + lastName);
    }

    private static String findLastName(ArrayDeque<String> queue, int n) {
        int roundCycle = 1;
        // make a while loop and remove a child if it's not a prime round and if it's only one kid left break
        while (queue.size() > 1) {
            for(int i = 1; i < n; i++) {
                //remove first name and put it on the last position
                queue.offer(queue.poll());
            }
            //check if round number is prime
            if(isPrime(roundCycle)) {
                System.out.println("Prime " + queue.peek());
            }else{
                //if it's not prime  remove the child
                System.out.println("Removed " + queue.poll());
            }
            //increment cycle
            roundCycle++;
        }
        //return last child
        return queue.poll();
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int j = 2; j <= Math.sqrt(number); j++) {
            if (number % j == 0) {
                return false;
            }
        }
        return true;
    }

    private static int readNumber(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static ArrayDeque<String> fillCollection(BufferedReader br) throws IOException {
        String[] inputArr = br.readLine().split("\\s+");
       ArrayDeque<String> queue = new ArrayDeque<>();
       for(String name : inputArr){
           queue.offer(name);
       }
        return queue;
    }
}
