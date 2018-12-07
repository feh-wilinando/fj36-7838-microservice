package br.com.cdc.buyer.persistence;

import br.com.cdc.buyer.application.repository.CreateBuyerRepository;
import br.com.cdc.buyer.application.repository.ShowBuyerRepository;
import br.com.cdc.buyer.domain.Buyer;
import org.springframework.data.repository.Repository;

public interface BuyerRepository extends Repository<Buyer, Long>, CreateBuyerRepository, ShowBuyerRepository {
}
