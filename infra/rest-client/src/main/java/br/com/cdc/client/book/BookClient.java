package br.com.cdc.client.book;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@Primary
@FeignClient(name = "book", fallback = BookClient.Fallback.class)
public interface BookClient {

    @GetMapping("{id}")
    BookResponse loadBookBy(@PathVariable Long id);

    @Component
    class Fallback implements BookClient {
        @Override
        public BookResponse loadBookBy(Long id) {
            return new BookResponse("Unknown", BigDecimal.ZERO, "Unknown");
        }
    }
}
