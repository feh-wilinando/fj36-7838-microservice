package br.com.cdc.buyer.presentation;

import br.com.cdc.buyer.application.ShowBuyer;
import br.com.cdc.buyer.presentation.response.BuyerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class ShowBuyerController {
    private static final Logger LOG = LoggerFactory.getLogger(ShowBuyerController.class);
    private final ShowBuyer useCase;

    public ShowBuyerController(ShowBuyer useCase) {
        this.useCase = useCase;
    }

    @GetMapping("{id}")
    public ResponseEntity<BuyerResponse> getById(@PathVariable Long id) {

        LOG.info("Request Buyer with id {}", id);

        return useCase.showBy(id).map(BuyerResponse::new).map(ok()::body).orElseGet(notFound()::build);
    }
}
