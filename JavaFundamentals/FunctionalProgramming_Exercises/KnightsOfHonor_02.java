package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class KnightsOfHonor_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] names = readInputArr(br);
        Consumer<String> printNameAndSir = (name) -> System.out.println("Sir " + name);
        printOutput(names, printNameAndSir);
    }

    private static void printOutput(String[] names, Consumer<String> printNameAndSir) {
        for(String name : names){
            printNameAndSir.accept(name);
        }
    }

    private static String[] readInputArr(BufferedReader br) throws IOException {
        return br.readLine().split("\\s+");
    }
}
