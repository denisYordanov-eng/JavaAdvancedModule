package generic_add_all_method;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {
    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return list.stream().sorted((e1, e2) -> e2.compareTo(e1)).collect(Collectors.toList()).get(0);
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return list.stream().sorted(Comparable::compareTo).collect(Collectors.toList()).get(0);
    }

    public static <T> List<Integer> getNullIndices(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        List<Integer> nulls = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                nulls.add(i);
            }
        }
        return nulls;
    }


    public static void flatten(List<Number> dest, List<List<? extends Number>> jagged) {
        for(List<? extends Number> innerList : jagged){
            dest.addAll(innerList);

        }
    }

    public static <T> void addAll(List<? super T> destination, List<? extends T> source){
       destination.addAll(source);
    }
}
