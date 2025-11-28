package StreamApi_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class AverageOfDoubles_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        DoubleStream numbers = Arrays.stream((br.readLine())
                        .split("\\s+"))
                .filter(n -> !n.isEmpty())
                .mapToDouble(Double::parseDouble);

        OptionalDouble average = numbers.average();

        if (average.isPresent()) {
            System.out.printf("%.2f%n", average.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
