package generic_count_method_string;

import java.util.List;

public class Box {

    public static <T extends Comparable >  int  countOfItemsBiggerThanElement(List<T> items, String element){
        int count = 0;
        for (T item : items) {
            if(item.compareTo(element) > 0){
                count++;
            }
        }
        return  count;
    }
}
