package br.com.cdc.buyer.application;

import br.com.cdc.buyer.application.repository.ShowBuyerRepository;
import br.com.cdc.buyer.domain.Buyer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowBuyer {
    private final ShowBuyerRepository repository;

    public ShowBuyer(ShowBuyerRepository repository) {
        this.repository = repository;
    }

    public Optional<Buyer> showBy(Long id) {
        return repository.findById(id);
    }
}
