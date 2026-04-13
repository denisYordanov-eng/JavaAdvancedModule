package generic_count_method_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            boxes.add(input);
        }
        String compareItem = br.readLine();
        int countCompare = Box.countOfItemsBiggerThanElement(boxes,compareItem);
        System.out.println(countCompare);
    }
}
