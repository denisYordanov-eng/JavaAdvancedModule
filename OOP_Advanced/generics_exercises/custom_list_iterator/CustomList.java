package custom_list_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList <T extends Comparable<T>> implements Iterable<T> {
    private List<T> list;

    public CustomList() {
        list = new ArrayList<>();
    }

    public List<T> getList() {
        return list;
    }

    public void add(T element){
        list.add(element);
    }

    public T remove(int index){
        return list.remove(index);
    }

    public boolean contains(T element){
        if (list.contains(element)){
            return true;
        }
        return false;
    }

    public void swap(int index1, int index2){
        T temp = list.get(index1);
        T temp2 = list.get(index2);
        list.set(index1,temp2);
        list.set(index2,temp);
    }

    public 	int countGreaterThan(T element){
        int count = 0;
        for(T element1 : list){
            if(element1.compareTo(element)>0){
                count++;
            }
        }
        return count;
    }
    public T getMax(){
        T max = list.get(0);
        for(T element1 : list){
            if (element1.compareTo(max) > 0){
                max = element1;
            }
        }
        return max;
    }

    public T getMin(){
        T min = list.get(0);
        for(T element1 : list){
            if (element1.compareTo(min) < 0){
                min = element1;
            }
        }
        return min;
    }

    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }
}
