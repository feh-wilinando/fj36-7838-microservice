package br.com.cdc.buyer.application.repository;

import br.com.cdc.buyer.domain.Buyer;

public interface CreateBuyerRepository {
    void save(Buyer buyer);
}
