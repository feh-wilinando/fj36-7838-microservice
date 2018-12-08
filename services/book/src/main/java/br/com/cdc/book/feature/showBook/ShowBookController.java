package br.com.cdc.book.feature.showBook;

import br.com.cdc.book.shared.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class ShowBookController {

    private final ShowBookService service;

    public ShowBookController(ShowBookService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> showById(@PathVariable Long id) {
        return service.showBookBy(id).map(ok()::body).orElseGet(notFound()::build);
    }
}
