package book_comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {


    private String title;
    private Integer year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        setTitle(title);
        setYear(year);
        setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(int year) {

        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(String... authors) {
        this.authors = new ArrayList<String>(Arrays.asList(authors));
    }
    @Override
    public int compareTo(Book b2) {
        if(this.title.compareTo(b2.title) == 0){
            return this.year.compareTo(b2.year);
        }
        return this.title.compareTo(b2.title);
    }
}

