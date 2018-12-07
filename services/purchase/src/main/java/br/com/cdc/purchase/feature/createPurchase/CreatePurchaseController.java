package br.com.cdc.purchase.feature.createPurchase;

import br.com.cdc.purchase.shared.dtos.PurchaseOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.http.ResponseEntity.created;

@RestController
public class CreatePurchaseController {

    private final CreatePurchaseService service;

    public CreatePurchaseController(CreatePurchaseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createBy(@RequestBody PurchaseOrder order) {
        Long id = service.createPurchaseFrom(order);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}").build(id);

        return created(uri).build();
    }
}
