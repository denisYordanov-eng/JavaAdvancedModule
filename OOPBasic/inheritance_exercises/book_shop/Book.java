package inheritance_exercises.book_shop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book {
    private String title;

    private String author;

    private double price;

    public Book(String author, String title, double price) {
        setAuthor(author);
        setTitle(title);
        setPrice(price);
    }

    protected double getPrice() {
        return price;
    }

    protected void setAuthor(String author) {
        String regexPattern = "[A-Za-z]+\\s+[0-9a-z]+";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(author);
        if (matcher.find()) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    protected void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator());
        sb.append("Title: ").append(this.title)
                .append(System.lineSeparator());
        sb.append("Author: ").append(this.author)
                .append(System.lineSeparator());
        sb.append("Price: ").append(String.format("%.1f", this.getPrice()))
                .append(System.lineSeparator());
        return sb.toString();
    }
}
