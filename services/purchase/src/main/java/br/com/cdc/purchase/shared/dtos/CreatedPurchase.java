package br.com.cdc.purchase.shared.dtos;

import br.com.cdc.client.buyer.BuyerResponse;
import br.com.cdc.purchase.shared.Purchase;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CreatedPurchase {

    private Purchase purchase;
    private BuyerResponse buyer;
    private List<ProductItem> items;

    /**
     * @deprecated jackson eyes only
     */
    @Deprecated
    private CreatedPurchase() {}

    public CreatedPurchase(Purchase purchase, BuyerResponse buyer, List<ProductItem> items) {
        this.purchase = purchase;
        this.buyer = buyer;
        this.items = items;
    }

    public Long getId() {
        return purchase.getId();
    }

    public LocalDateTime getDate() {
        return purchase.getDate();
    }

    public BigDecimal getTotal() {
        return purchase.getTotal();
    }

    public List<ProductItem> getItems() {
        return items;
    }

    public String getBuyer() {
        return buyer.getName();
    }
}
