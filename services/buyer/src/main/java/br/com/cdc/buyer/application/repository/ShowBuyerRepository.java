package br.com.cdc.buyer.application.repository;

import br.com.cdc.buyer.domain.Buyer;

import java.util.Optional;

public interface ShowBuyerRepository {
    Optional<Buyer> findById(Long id);
}
