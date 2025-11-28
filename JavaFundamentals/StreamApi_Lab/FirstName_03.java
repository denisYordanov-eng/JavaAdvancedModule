package StreamApi_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstName_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(br.readLine()
                        .split("\\s+"))
                .collect(Collectors.toList());

        HashSet<Character> targetChar = new HashSet<>();

        Stream.of(br.readLine().split("\\s+"))
                .map(c -> c.toLowerCase().charAt(0))
                .forEach(c -> targetChar.add(c));

        Optional<String> first = names.stream()
                .filter(s ->
                        targetChar.contains(s.toLowerCase().charAt(0)))
                .sorted()
                .findFirst();
        if (first.isPresent()) {
            System.out.println(first.get());
        }else {
            System.out.println("No match");
        }
    }

}
