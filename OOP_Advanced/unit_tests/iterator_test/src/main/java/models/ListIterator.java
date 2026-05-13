package models;

import Interfaces.ListCommands;

import javax.naming.OperationNotSupportedException;

import java.util.Iterator;
import java.util.List;

public class ListIterator<T> implements ListCommands<T>, Iterable<T> {
    private List<T> list;

    int currentIndex;

    public ListIterator(List<T> list) throws OperationNotSupportedException {
        this.list = list;
        if (this.list == null) {
            throw new OperationNotSupportedException();
        }
        this.currentIndex = 0;
    }

    @Override
    public int getCurrentIndex() {
        return currentIndex;
    }

    @Override
    public boolean move() throws OperationNotSupportedException {
        if(list.isEmpty()) {
            throw new OperationNotSupportedException("List is empty!");
        }
        if (hasNext()) {
            currentIndex++;
            return true;
        }
        return false;
    }
@Override
    public boolean hasNext() throws OperationNotSupportedException {
        if(list.isEmpty()) {
            throw new OperationNotSupportedException("List is empty!");
        }
        return currentIndex < list.size();
    }

    public void print() throws OperationNotSupportedException {
        if (this.list.isEmpty()) {
            throw new OperationNotSupportedException("List is empty!");
        }
        T currentElement = list.get(currentIndex);
        System.out.println(currentElement);
    }

    @Override
    public Iterator<T> iterator() {
        return  new ListyIterator();
    }
    private final class ListyIterator implements Iterator<T> {
        private  int index;

        public ListyIterator() {
            this.index = 0;
        }

        public boolean hasNext() {
            return index < list.size() - 1;
        }

        public T next() {
            return  list.get(index++);
        }

    }
}


