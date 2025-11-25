package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FindTheSmallestElement_08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = readList(br);

        Function <List<Integer>,Integer> findSmallestNumber = list ->{
            int smallest = numbers.get(0);
            int index = 0;
         for(int i = 0;i < list.size(); i++){
             if(list.get(i) <= smallest){
                 smallest = list.get(i);
                 index = i;
             }
         }
         return  index;
        };
            int smallestIndex = findSmallestNumber.apply(numbers);
            printSmallest(smallestIndex);
    }

    private static void printSmallest(int smallestIndex) {
        System.out.println(smallestIndex);
    }


    private static List<Integer> readList(BufferedReader br) throws IOException {
        return  Arrays.stream(br.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
