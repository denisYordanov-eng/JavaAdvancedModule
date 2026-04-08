package generics_lab.one_jar_of_T;

import java.util.ArrayDeque;
import java.util.Deque;


public class Jar<T> implements Jarable<T> {
    private Deque<T> elements;

    public Jar() {
        this.elements = new ArrayDeque<>();
    }

    @Override
    public void add(T element) {
        this.elements.push(element);
    }

    @Override
    public  T remove() {
        return elements.pop();
    }
}
