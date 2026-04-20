package stack_iterator;


import java.util.*;

public class StackIter<T extends Number> implements Iterable<T> {
    private List<T> stack = new ArrayList<>();

@SuppressWarnings("unchecked")
    public StackIter(T... stack) {
        this.stack.addAll(Arrays.asList(stack));
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException("No elements");
        }
        stack.remove(stack.size() - 1);
    }

    public void push(T element) {
        stack.add(element);
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    public final class StackIterator implements Iterator<T> {
       private int index = stack.size() - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public T next() {
            return stack.get(index--);
        }
    }
}
