package custom_list_iterator;

import java.util.List;

public class Sorter {
    public  static<T extends Comparable>  void sort(List<T> list){
        boolean swap;

        do{
            swap = false;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).compareTo(list.get(i+1)) > 0) {
                    T temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, temp);
                    swap = true;
                }
            }
        }while(swap);
    }
}
