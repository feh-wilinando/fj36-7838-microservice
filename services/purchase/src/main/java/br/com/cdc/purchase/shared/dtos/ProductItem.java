package br.com.cdc.purchase.shared.dtos;

import br.com.cdc.client.book.BookResponse;

import java.math.BigDecimal;

public class ProductItem {

    private final BookResponse book;

    public ProductItem(BookResponse book) {
        this.book = book;
    }

    public String getTitle() {
        return book.getTitle();
    }

    public BigDecimal getPrice() {
        return book.getPrice();
    }

    public String getAuthor() {
        return book.getAuthor();
    }
}
