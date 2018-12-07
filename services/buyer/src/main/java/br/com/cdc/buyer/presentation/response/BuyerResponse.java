package br.com.cdc.buyer.presentation.response;

import br.com.cdc.buyer.application.result.CreatedBuyer;
import br.com.cdc.buyer.domain.Buyer;

public class BuyerResponse implements CreatedBuyer {
    private String name;
    private String email;

    public BuyerResponse(Buyer buyer) {
        name = buyer.getName();
        email = buyer.getEmail();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }
}
