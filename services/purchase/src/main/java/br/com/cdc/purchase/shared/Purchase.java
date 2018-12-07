package br.com.cdc.purchase.shared;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long userId;

    private LocalDateTime date;

    @NotNull
    @Size(min = 1)
    @ElementCollection
    private List<Product> products = new ArrayList<>();

    /**
     * @deprecated hibernate eyes only
     */
    @Deprecated
    private Purchase() {
    }

    public Purchase(@NotNull Long userId, @NotNull @Size(min = 1) List<Product> products) {
        this.date = LocalDateTime.now();
        this.userId = userId;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getTotal() {
        return products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
