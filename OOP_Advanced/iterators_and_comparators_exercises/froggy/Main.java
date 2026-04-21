package froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[] numbers = Arrays.stream(br.readLine().split("[,\\s]+"))
                .filter(n -> !n.isEmpty())
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        Lake<Integer> lake = new Lake<>(numbers);

        List<String> output = new ArrayList<>();
        for (Integer steps: lake){
          output.add(steps.toString());
        }
        System.out.println(String.join(", ", output));
    }
}
