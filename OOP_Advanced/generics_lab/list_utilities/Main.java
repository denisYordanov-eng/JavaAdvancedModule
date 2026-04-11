package list_utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Integer> list = new ArrayList<>();
            Collections.addAll(list, 1, 2, 18, 2, -1);

            Integer maxInteger = ListUtils.getMin(list);

            List<String> strings = new ArrayList<>();
            Collections.addAll(strings, "a", "b", "c");


            String minString = ListUtils.getMin(strings);

            System.out.println(maxInteger);

            System.out.println(minString);

        } catch (IllegalArgumentException iae) {
            System.out.println("list is empty");
        }
    }
}
