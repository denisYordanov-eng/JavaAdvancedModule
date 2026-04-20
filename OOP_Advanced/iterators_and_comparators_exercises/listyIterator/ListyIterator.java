package listyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator<T> implements Iterable<T> {
    private List<T> elements;
    private int currentIndex;

    @SafeVarargs
    public ListyIterator(T... elements) {
        this.elements = new ArrayList<>(Arrays.asList(elements));
        this.currentIndex = 0;
    }

    public boolean move(){
        if(hasNext()) {
            this.currentIndex++;
            return true;
        }
        return false;
    }

    public boolean hasNext(){
        if(this.currentIndex < this.elements.size() - 1) {
            return true;
        }
        return false;
    }
    public void print(){
       if(elements.isEmpty()) {
           throw  new IllegalArgumentException("Invalid Operation!");
       }
        System.out.println(elements.get(currentIndex));
    }



    @Override
    public Iterator<T> iterator() {
        return new Listy();
    }
    private final class Listy implements Iterator<T> {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < elements.size() - 1;
        }

        @Override
        public T next() {
            return elements.get(index++);
        }
    }
}
