package br.com.cdc.purchase.shared;

import javax.persistence.Embeddable;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Embeddable
public class Product {
    @NotNull
    private Long id;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal price;

    /**
     * @deprecated hibernate eyes only
     */
    @Deprecated
    private Product() { }

    public Product(@NotNull Long id, @NotNull @DecimalMin("0.0") BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
