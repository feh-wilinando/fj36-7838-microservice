package br.com.cdc.author.showAuthor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class ShowAuthorController {

    private final ShowAuthorService service;

    public ShowAuthorController(ShowAuthorService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<AuthorResponse> showAuthorById(@PathVariable Long id) {
        return service.loadAuthorBy(id).map(ok()::body).orElseGet(notFound()::build);
    }
}
