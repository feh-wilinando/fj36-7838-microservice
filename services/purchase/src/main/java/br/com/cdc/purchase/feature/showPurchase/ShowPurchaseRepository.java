package br.com.cdc.purchase.feature.showPurchase;

import br.com.cdc.purchase.shared.Purchase;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface ShowPurchaseRepository extends Repository<Purchase, Long> {
    Optional<Purchase> findById(Long id);
}
