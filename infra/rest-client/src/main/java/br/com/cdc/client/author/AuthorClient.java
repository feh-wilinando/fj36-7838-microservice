package br.com.cdc.client.author;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Primary
@FeignClient(name = "author", fallback = AuthorClient.Fallback.class)
public interface AuthorClient  {

    @GetMapping("{id}")
    AuthorResponse loadAuthorBy(@PathVariable Long id);

    @Component
    class Fallback implements AuthorClient {
        private static final Logger LOG = LoggerFactory.getLogger(Fallback.class);

        @Override
        public AuthorResponse loadAuthorBy(Long id) {
            LOG.warn("[AUTHOR] [CLIENT] Cannot load author with id {}, then was start using fallback", id);

            return new AuthorResponse("Unknown");
        }
    }
}
