package br.com.cdc.book.feature.showBook;

import br.com.cdc.book.shared.Book;
import br.com.cdc.client.author.AuthorResponse;

import java.math.BigDecimal;

public class BookView {
    private final Book book;
    private final AuthorResponse author;


    BookView(Book book, AuthorResponse author) {
        this.book = book;
        this.author = author;
    }

    public String getTitle() {
        return book.getTitle();
    }

    public BigDecimal getPrice() {
        return book.getPrice();
    }

    public String getAuthor() {
        return author.getName();
    }
}
