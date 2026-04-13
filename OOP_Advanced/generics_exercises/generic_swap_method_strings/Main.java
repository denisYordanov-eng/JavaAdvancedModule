package generic_swap_method_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main<T> {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Box[] boxes = new Box[n];


        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            boxes[i] = new Box(input);
        }
        int[] swaps = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstElementIndex = swaps[0];
        int secondElementIndex = swaps[1];

        Box firstBox = boxes[firstElementIndex];
        Box secondBox = boxes[secondElementIndex];
        boxes[firstElementIndex] = secondBox;
        boxes[secondElementIndex] = firstBox;

        for (Box box : boxes) {
            System.out.println(box.toString());
        }
    }
}
