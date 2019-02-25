package br.com.cdc.client.buyer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Primary
@FeignClient(name = "buyer", fallback = BuyerClient.Fallback.class)
public interface BuyerClient {

    @GetMapping("{id}")
    BuyerResponse loadBuyerBy(@PathVariable Long id);

    @Component
    class Fallback  implements BuyerClient {
        @Override
        public BuyerResponse loadBuyerBy(Long id) {
            return new BuyerResponse("Unknown","Unknown");
        }
    }
}
