package Functional_Programing_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;

public class SumNumbers_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        String[] inputElements = readElements(br);

        int[] numbers = new int[inputElements.length];

        Function<String , Integer> num = x -> Integer.parseInt(x);

        int counter = 0;
        int sum = 0;

        for (String inputElement : inputElements) {
            sum += num.apply(inputElement);
            counter++;
        }

        Consumer<Integer> printCounter = (elementsCount) ->{
            System.out.println("Count = " + elementsCount);
        };

        Consumer<Integer> printSum  = (value)-> {
            System.out.println("Sum = " + value);
        };
        printCounter.accept(counter);
        printSum.accept(sum);
    }

    private static String[] readElements(BufferedReader br) throws IOException {
        return br.readLine().split(", ");
    }
}
