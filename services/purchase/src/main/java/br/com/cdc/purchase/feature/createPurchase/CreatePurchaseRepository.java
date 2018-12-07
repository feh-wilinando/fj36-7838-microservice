package br.com.cdc.purchase.feature.createPurchase;

import br.com.cdc.purchase.shared.Purchase;
import org.springframework.data.repository.Repository;

public interface CreatePurchaseRepository extends Repository<Purchase, Long> {
    void save(Purchase purchase);
}
