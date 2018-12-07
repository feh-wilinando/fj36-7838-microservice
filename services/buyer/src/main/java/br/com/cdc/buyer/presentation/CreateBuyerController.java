package br.com.cdc.buyer.presentation;

import br.com.cdc.buyer.application.CreateBuyer;
import br.com.cdc.buyer.presentation.request.BuyerInformation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.http.ResponseEntity.created;

@RestController
public class CreateBuyerController {

    private final CreateBuyer useCase;

    public CreateBuyerController(CreateBuyer useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BuyerInformation personalInfo) {
        Long id = useCase.createBuyerWith(personalInfo.getName(), personalInfo.getEmail());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}").build(id);

        return created(uri).build();
    }
}
