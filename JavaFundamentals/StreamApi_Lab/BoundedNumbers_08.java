package StreamApi_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BoundedNumbers_08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> targetNumbers = readList(br);
        List<Integer> numbers = readList(br);


        numbers.stream()
                .filter(getNumbersInTargetZone(targetNumbers))
                .forEach(n -> System.out.print(n + " "));
    }

    private static List<Integer> readList(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static Predicate<Integer> getNumbersInTargetZone(List<Integer> targetNumbers) {
        int lowerNumber = Math.min(targetNumbers.get(0),targetNumbers.get(1));
        int upperNumber = Math.max(targetNumbers.get(0),targetNumbers.get(1));
        return n -> n >= lowerNumber && n <= upperNumber;
    }
}
