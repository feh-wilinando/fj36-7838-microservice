package br.com.cdc.book.shared;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    private Long authorId;

    private BigDecimal price;

    /**
     * @deprecated hibernate eyes only
     */
    @Deprecated
    private Book() { }

    public Book(@NotNull String title, Long authorId, BigDecimal price) {
        this.title = title;
        this.authorId = authorId;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
