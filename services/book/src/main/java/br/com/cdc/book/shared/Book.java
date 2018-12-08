package br.com.cdc.book.shared;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @OneToOne
    private Author author;

    private BigDecimal price;

    /**
     * @deprecated hibernate eyes only
     */
    @Deprecated
    private Book() { }

    public Book(@NotNull String title, Author author, BigDecimal price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String  getAuthor() {
        return author.getName();
    }

    public BigDecimal getPrice() {
        return price;
    }
}
