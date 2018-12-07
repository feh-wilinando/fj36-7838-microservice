package br.com.cdc.client.book;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "book", fallback = BookClient.Fallback.class)
public interface BookClient {
    @GetMapping("{id}")
    BookResponse loadBookBy(@PathVariable Long id);

    @Configuration
    class Fallback implements BookClient {
        @Override
        public BookResponse loadBookBy(Long id) {
            return new BookResponse("Unknown", BigDecimal.ZERO, "Unknown");
        }
    }
}
