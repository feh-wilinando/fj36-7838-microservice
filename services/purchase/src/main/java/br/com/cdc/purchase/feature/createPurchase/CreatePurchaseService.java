package br.com.cdc.purchase.feature.createPurchase;

import br.com.cdc.purchase.shared.Purchase;
import br.com.cdc.purchase.shared.dtos.PurchaseOrder;
import org.springframework.stereotype.Service;

@Service
class CreatePurchaseService {
    private final CreatePurchaseRepository repository;

    CreatePurchaseService(CreatePurchaseRepository repository) {
        this.repository = repository;
    }

    Long createPurchaseFrom(PurchaseOrder order) {
        Purchase purchase = order.toDomain();

        repository.save(purchase);

        return purchase.getId();
    }
}
