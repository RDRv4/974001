package lab4;

import Books.Book;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Book[] books = new Book[3];

        for(int i = 0; i < 3; i++) {
            books[i] = new Book();
        }

        for(int i = 0; i < 3; i++) {
            books[i].Input();
        }
        Book.priceSum(books);
        Book.illustrationsCount(books);
        Book.Output();
    }
}
