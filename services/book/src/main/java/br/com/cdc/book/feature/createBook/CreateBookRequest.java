package br.com.cdc.book.feature.createBook;

import br.com.cdc.book.shared.Book;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CreateBookRequest {
    @NotBlank
    private String title;

    @NotNull
    @Min(1)
    private Long authorId;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal price;

    /**
     * @deprecated jackson eyes only
     */
    @Deprecated
    private CreateBookRequest() { }

    public CreateBookRequest(String title, Long authorId) {
        this.title = title;
        this.authorId = authorId;
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

    public Book toDomain() {
        return new Book(title, authorId, price);
    }
}
