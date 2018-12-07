package br.com.cdc.purchase.shared.dtos;

import br.com.cdc.purchase.shared.Product;
import br.com.cdc.purchase.shared.Purchase;

import java.util.List;

public class PurchaseOrder {
    private Long userId;
    private List<Product> products;


    /**
     * @deprecated jackson eyes only
     */
    @Deprecated
    private PurchaseOrder() {
    }

    public PurchaseOrder(Long userId, List<Product> products) {
        this.userId = userId;
        this.products = products;
    }

    public Long getUserId() {
        return userId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Purchase toDomain() {
        return new Purchase(userId, products);
    }
}
