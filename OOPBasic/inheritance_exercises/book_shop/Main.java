package inheritance_exercises.book_shop;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String author = br.readLine();
        String bookName = br.readLine();
        double price = Double.parseDouble(br.readLine());

        try {
            Book book = new Book(author, bookName, price);
            System.out.println(book);

            GoldenEditionBook geb = new GoldenEditionBook(author, bookName, price);
            System.out.println(geb);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
