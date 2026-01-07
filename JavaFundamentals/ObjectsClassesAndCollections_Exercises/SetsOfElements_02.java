package ObjectsClassesAndCollections_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetsOfElements_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = readArr(br);
        int firstLengthSet = arr[0];
        int secondLength = arr[1];

        LinkedHashSet<Integer> firstSet = fillSet(firstLengthSet,br);
        LinkedHashSet<Integer> secondSet = fillSet(secondLength,br);

        for (int numberOne : firstSet) {
            for (int numberTwo : secondSet) {
                if (numberOne == numberTwo) {
                    System.out.printf("%d ", numberOne);
                }
            }
        }
    }

    private static LinkedHashSet<Integer> fillSet(int length, BufferedReader br) throws IOException {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < length; i++) {
            int currentNum = Integer.parseInt(br.readLine());
            set.add(currentNum);
        }
        return set;
    }

    private static int[] readArr(BufferedReader br) throws IOException {
        return  Arrays.stream(br.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
