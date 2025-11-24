package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class ConsumerPrint_01_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] names = readInputArr(br);

        Consumer<String> print = (name) -> {
            System.out.println(name);
        };
        printOutput(print,names);
    }

    private static void printOutput(Consumer<String> print, String[] names) {
        for(String name : names){
            print.accept(name);
        }
    }

    private static String[] readInputArr(BufferedReader br) throws IOException {
        return br.readLine().split("\\s+");
    }
}
