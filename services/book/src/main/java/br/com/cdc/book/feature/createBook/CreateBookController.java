package br.com.cdc.book.feature.createBook;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.http.ResponseEntity.created;

@RestController
public class CreateBookController {

    private final CreateBookService service;

    public CreateBookController(CreateBookService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createBy(@RequestBody CreateBookRequest request) {
        Long id = service.createBookBy(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}").build(id);

        return created(uri).build();

    }
}
