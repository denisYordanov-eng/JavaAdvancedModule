package ObjectsClassesAndCollections_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;

public class HotPotato_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> queue = new ArrayDeque<>();
       queue = fillQueue(br);
        int n = readNumber(br);
       String lastOne = findLastName(queue,n);
       printLastOne(lastOne);
    }

    private static void printLastOne(String lastOne) {
        System.out.println("Last is " + lastOne);
    }

    private static String findLastName(ArrayDeque<String> queue, int n) {
        while(queue.size() > 1){
            for(int i = 1; i < n; i++){
                //take first element and put it to be last n - 1 times
                queue.offer(queue.poll());
            }
            //remove first element of n times
            System.out.println("Removed " + queue.poll());
        }
        //return the last
        return queue.poll();
    }

    private static int readNumber(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static ArrayDeque<String> fillQueue(BufferedReader br) throws IOException {
       String[] inputs = br.readLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String name : inputs) {
            queue.offer(name);
        }
        return queue;
    }
}
