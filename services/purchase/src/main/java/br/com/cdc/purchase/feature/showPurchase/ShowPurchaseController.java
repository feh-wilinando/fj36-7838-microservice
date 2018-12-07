package br.com.cdc.purchase.feature.showPurchase;

import br.com.cdc.purchase.shared.dtos.CreatedPurchase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class ShowPurchaseController {

    private final ShowPurchaseService service;

    public ShowPurchaseController(ShowPurchaseService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<CreatedPurchase> showById(@PathVariable Long id) {
        return service.show(id).map(ok()::body).orElseGet(notFound()::build);
    }
}
