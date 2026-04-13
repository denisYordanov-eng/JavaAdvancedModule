package generic_count_method_doubles;

import java.util.List;

public class Box {
    public static <T extends Comparable> int compareCount(List<T>  items, double element){
        int count = 0;
        for (T item : items) {
            if(item.compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }
}
