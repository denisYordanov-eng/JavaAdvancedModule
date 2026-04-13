package generic_swap_method_integers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Box[] boxes = new Box[n];

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            boxes[i] = new Box(number);
        }
        int[] indexes = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstIndex = indexes[0];
        int secondIndex = indexes[1];
        Box firstBox = boxes[firstIndex];
        Box secondBox = boxes[secondIndex];
        boxes[firstIndex] = secondBox;
        boxes[secondIndex] = firstBox;

        for (int i = 0; i < n; i++) {
            System.out.println(boxes[i].toString());
        }

    }
}
