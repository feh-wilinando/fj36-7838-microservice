package br.com.cdc.author.createAuthor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.http.ResponseEntity.created;

@RestController
public class CreateAuthorController {
    private final CreateAuthorService service;

    public CreateAuthorController(CreateAuthorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createAuthorByRequest(@RequestBody CreateAuthorRequest request) {
        Long id = service.createAuthorBy(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}").build(id);

        return created(uri).build();
    }
}
