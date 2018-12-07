package br.com.cdc.client.book;

import java.math.BigDecimal;

public class BookResponse {
    private String title;
    private BigDecimal price;
    private String author;

    /**
     * @deprecated feign eyes only
     */
    @Deprecated
    private BookResponse() { }

    public BookResponse(String title, BigDecimal price, String author) {
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }
}
