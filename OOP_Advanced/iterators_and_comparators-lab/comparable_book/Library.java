package comparable_book;

import java.util.ArrayList;
import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;
    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new bookIterator();
    }
    private final class bookIterator implements Iterator<Book> {
        int index = 0;
        @Override
        public boolean hasNext() {
            if(index < books.length - 1) {
                return true;
            }
            return false;
        }

        @Override
        public Book next() {
            return books[index++];
        }
    }
}
