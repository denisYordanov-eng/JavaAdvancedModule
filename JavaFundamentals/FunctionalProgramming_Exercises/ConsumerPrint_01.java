package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.function.Consumer;

public class ConsumerPrint_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> names = new ArrayDeque<>();
       fillStack(br, names);
       Consumer<String> printName = (name) ->{
           System.out.println(name);
       };
       printOutput(printName,names);
    }

    private static void printOutput(Consumer<String> printName, ArrayDeque<String> names) {
        while (!names.isEmpty()) {
            printName.accept(names.removeLast());
        }
    }

    private static void fillStack(BufferedReader br, ArrayDeque<String> names) throws IOException {
        String[] input = br.readLine().split("\\s+");
        for (String string : input) {
            names.addFirst(string);
        }
    }


}
