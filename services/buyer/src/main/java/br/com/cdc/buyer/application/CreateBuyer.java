package br.com.cdc.buyer.application;

import br.com.cdc.buyer.application.repository.CreateBuyerRepository;
import br.com.cdc.buyer.domain.Buyer;
import org.springframework.stereotype.Service;

@Service
public class CreateBuyer {

    private final CreateBuyerRepository repository;

    public CreateBuyer(CreateBuyerRepository repository) {
        this.repository = repository;
    }

    public Long createBuyerWith(String name, String email) {
        Buyer buyer = new Buyer(name, email);

        repository.save(buyer);

        return buyer.getId();
    }

}
