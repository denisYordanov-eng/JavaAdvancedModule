package book_comparator;

import java.util.Comparator;

public class BookComparator  implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        if(b1.compareTo(b2) == 0){
            return b1.getYear().compareTo(b2.getYear());
        }
        return b1.compareTo(b2);
    }
}
